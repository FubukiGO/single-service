package com.ygg.baba.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.util.R;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUrlAuthenticationEntryPointImpl implements AuthenticationEntryPoint, InitializingBean {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    @SneakyThrows
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType(CommonConstant.CONTENT_TYPE);
        res.setStatus(HttpServletResponse.SC_OK);
        R result = new R(999, "请先登录!");
        res.getWriter().println(objectMapper.writeValueAsString(result));
    }
}
