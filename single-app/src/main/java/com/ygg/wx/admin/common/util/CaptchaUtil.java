package com.ygg.wx.admin.common.util;

import cn.hutool.http.HttpStatus;
import com.google.code.kaptcha.Producer;
import com.ygg.wx.admin.security.AuthManager;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: akhan
 * @Description: 验证码生成
 * @Date: 17:59 2019-03-05
 */
@Component
public class CaptchaUtil {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisTemplate redisTemplate;

    public void createCaptcha(HttpServletResponse response, String namespace) throws IOException {
        Integer loginId = null;
        try {
            loginId = AuthManager.getUserId();
        } catch (Exception e) {
            response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
            return;
        }

        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        redisTemplate.opsForValue().set(namespace + loginId, text, 5, TimeUnit.MINUTES);
        BufferedImage image = producer.createImage(text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        IOUtils.closeQuietly(out);
    }
}
