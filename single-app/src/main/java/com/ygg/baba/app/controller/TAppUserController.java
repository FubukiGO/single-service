package com.ygg.baba.app.controller;

import com.google.code.kaptcha.Producer;
import com.ygg.baba.app.common.util.CaptchaUtil;
import com.ygg.baba.app.model.vo.AppUserVo;
import com.ygg.baba.app.service.ITAppUserService;
import com.ygg.baba.common.exception.BusinessException;
import com.ygg.baba.common.util.HttpHelper;
import com.ygg.baba.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * H5   用户表 前端控制器
 * </p>
 *
 * @author baba
 * @since 2018-08-14
 */
@RestController
@RequestMapping("/tAppUser")
@Api(description = "app用户操作", tags = "h5用户操作")
@Slf4j
@AllArgsConstructor
public class TAppUserController extends BaseController {

    private static final String CAPTCHA_VERIFY = "captcha:verify:";

    private final CaptchaUtil captchaUtil;
    private final Producer producer;
    private final ITAppUserService appUserService;
    private final RedisTemplate redisTemplate;

    @PostMapping(value = "login")
    @ApiOperation(value = "app登陆", notes = "phone,pwd", response = AppUserVo.class)
    public R login(@RequestBody Map<String, String> logMap) {
        AppUserVo appUserVo = null;
        if (StringUtils.isBlank(logMap.get("phone")) || StringUtils.isBlank(logMap.get("pwd"))) {
            throw new BusinessException("手机号码和密码不能为空");
        }
        if (!logMap.get("pwd").matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{8,16}$")) {
            throw new BusinessException("密码只能为8-16位数字字母");
        }

        //登录验证
        appUserVo = appUserService.login(logMap.get("phone"), logMap.get("pwd"), HttpHelper.getRemoteHost(httpServletRequest));

        return new R<>(appUserVo, "登录成功");
    }

    @SneakyThrows
    @GetMapping("captcha")
    @ApiOperation(value = "验证码", notes = "randNum", responseContainer = "R")
    public void captcha(String randNum, HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        redisTemplate.opsForValue().set("captcha:" + randNum, text, 5, TimeUnit.MINUTES);
        BufferedImage image = producer.createImage(text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        IOUtils.closeQuietly(out);
    }


    @PostMapping(value = "loginByCheckcode")
    @ApiOperation(value = "验证码登陆", notes = "phone,checkcode", response = AppUserVo.class)
    public R loginByCheckcode(@RequestBody Map<String, Object> logMap) {
        AppUserVo appUserVo = null;
        if (StringUtils.isEmpty(logMap.get("phone").toString())) {
            throw new BusinessException("手机号不能为空");
        }
        if (StringUtils.isEmpty(logMap.get("checkcode").toString())) {
            throw new BusinessException("验证码不能为空");
        }
        //登录验证
        appUserVo = appUserService.loginByCheckcode(logMap.get("phone").toString(), logMap.get("checkcode").toString());

        return new R<>(200, "登录成功", appUserVo);
    }
}

