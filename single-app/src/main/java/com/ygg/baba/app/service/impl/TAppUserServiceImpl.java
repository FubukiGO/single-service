package com.ygg.baba.app.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.app.common.util.JwtTokenUtils;
import com.ygg.baba.app.mapper.TAppUserMapper;
import com.ygg.baba.app.model.dto.AuthUser;
import com.ygg.baba.app.model.entity.TAppUser;
import com.ygg.baba.app.model.vo.AppUserVo;
import com.ygg.baba.app.service.ITAppUserService;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.exception.AccountLockedExeption;
import com.ygg.baba.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * H5   用户表 服务实现类
 * </p>
 *
 * @author baba
 * @since 2018-09-25
 */
@Service
@Slf4j
@AllArgsConstructor
public class TAppUserServiceImpl extends ServiceImpl<TAppUserMapper, TAppUser> implements ITAppUserService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    private final JwtTokenUtils jwtTokenUtils;
    private final RedisTemplate redisTemplate;

    /**
     * @author akhan
     * @description 授权用
     * @date 3:16 PM 2018/11/21
     */
    @Override
    @SneakyThrows
    @Cacheable(value = "auth_users", key = "'auth_' + #s")
    public AuthUser loadUserByUsername(String s) {
        return baseMapper.selectUserByUsername(s);
    }

    @Override
    public AppUserVo login(String phone, String pwd, String ip) {
        Date now = new Date();


        if (phone.trim().length() != 11) {
            throw new BusinessException("手机号位数存在问题,请检查手机号是否正确");
        }
        TAppUser login = null;
        try {
            login = this.getOne(Wrappers.<TAppUser>query().eq("phone", phone));
        } catch (Exception e) {
            throw new BusinessException("系统异常");
        }
        if (null == login) {
            throw new BusinessException("用户不存在");
        }

        //距离上次登陆失败是否超过24小时
        boolean loginErr = DateUtil.isExpired(login.getTodayDate() == null ? now : login.getTodayDate(), DateField.HOUR, 24, now);

        //如果当前时间是今天 并且密码错误次数为3次
        if (loginErr && login.getCountErrorLogin() == 3) {
            throw new AccountLockedExeption("今日账号已锁定，您可以重置密码登录或短信登录");
        }
        if (!ENCODER.matches(pwd, login.getPwd())) {
            //密码错误 且当前时间不是今天 计数重置
            if (!loginErr) {
                login.setCountErrorLogin(0);
            }
            login.setCountErrorLogin(login.getCountErrorLogin() + 1);
            login.setTodayDate(now);
            login.updateById();
            if (login.getCountErrorLogin() == 3) {
                throw new AccountLockedExeption("今日账号已锁定，您可以重置密码登录或短信登录");
            }
            throw new AccountLockedExeption("用户名或密码错误,错误" + (3 - login.getCountErrorLogin()) + "次后账户今日将锁定");
        }

        if (1 != login.getStatus()) {
            throw new BusinessException("用户异常，请联系客服");
        }

        AppUserVo userVo = new AppUserVo();
        BeanUtils.copyProperties(login, userVo);

        userVo.setUserId(login.getId());
        log.info("手机号为" + phone + "登录成功");
        login.setLastLoginTime(now);
        login.setLastLoginIp(ip);
        login.setCountErrorLogin(0);

        updateById(login);

        AuthUser auth = new AuthUser();
        BeanUtils.copyProperties(login, auth);

        userVo.setToken(CommonConstant.TOKEN_SPLIT + jwtTokenUtils.generateToken(auth));

        return userVo;
    }


    @Override
    public AppUserVo loginByCheckcode(String phone, String checkcode) {

        TAppUser tAppUser1 = this.getOne(Wrappers.<TAppUser>query().eq("phone", phone));

        if (null == tAppUser1) {
            throw new BusinessException("手机号未注册");
        }
        if (!checkcode.equals(redisTemplate.opsForValue().get(phone))) {
            throw new BusinessException("验证码错误");
        }
        AppUserVo userVo = new AppUserVo();
        userVo.setUserId(tAppUser1.getId());
        userVo.setHeadUrl(tAppUser1.getHeadUrl());
        userVo.setPhone(tAppUser1.getPhone());
        userVo.setName(tAppUser1.getName());
        userVo.setBalance(tAppUser1.getBalance());
        userVo.setIsBindCard(tAppUser1.getIsBindCard());
        userVo.setIsSetTranspwd(tAppUser1.getIsSetTranspwd());
        userVo.setIsCompletion(tAppUser1.getIsCompletion());

        AuthUser login = new AuthUser();
        BeanUtils.copyProperties(tAppUser1, login);

        userVo.setToken(CommonConstant.TOKEN_SPLIT + jwtTokenUtils.generateToken(login));

        log.info("手机号为" + phone + "登录成功");

        return userVo;
    }
}
