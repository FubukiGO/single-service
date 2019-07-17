package com.ygg.wx.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.date.DateField;
import com.xiaoleilu.hutool.date.DateUtil;
import com.ygg.debt.common.constants.CommonConstant;
import com.ygg.debt.common.exception.AccountLockedExeption;
import com.ygg.debt.common.exception.BusinessException;
import com.ygg.wx.admin.common.util.JwtTokenUtils;
import com.ygg.wx.admin.mapper.TAppUserMapper;
import com.ygg.wx.admin.model.dto.AuthUser;
import com.ygg.wx.admin.model.entity.TAppUser;
import com.ygg.wx.admin.model.vo.AppUserVo;
import com.ygg.wx.admin.service.ITAppUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TAppUserServiceImpl extends ServiceImpl<TAppUserMapper, TAppUser> implements ITAppUserService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Resource
    private TAppUserMapper tAppUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

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
            login = this.selectOne(new EntityWrapper<TAppUser>().eq("phone", phone));
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
        tAppUserMapper.updateById(login);

        AuthUser auth = new AuthUser();
        BeanUtils.copyProperties(login, auth);

        userVo.setToken(CommonConstant.TOKEN_SPLIT + jwtTokenUtils.generateToken(auth));

        return userVo;
    }


    @Override
    public AppUserVo loginByCheckcode(String phone, String checkcode) {
        TAppUser tAppUser1 = null;
        TAppUser tAppUser = new TAppUser();
        tAppUser.setPhone(phone);
        tAppUser1 = tAppUserMapper.selectOne(tAppUser);
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
