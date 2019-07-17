package com.ygg.debt.admin.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygg.debt.common.constants.CommonConstant;
import com.ygg.debt.common.util.R;
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
    public void afterPropertiesSet() {

    }

    @Override
    @SneakyThrows
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType(CommonConstant.CONTENT_TYPE);
        res.setStatus(HttpServletResponse.SC_OK);
        R result = new R(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "请先登录!");
        res.getWriter().println(objectMapper.writeValueAsString(result));
    }
}
