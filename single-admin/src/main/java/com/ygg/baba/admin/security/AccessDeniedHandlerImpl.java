package com.ygg.baba.admin.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType(CommonConstant.CONTENT_TYPE);
        res.setStatus(HttpServletResponse.SC_OK);
        R<Boolean> result = new R<>(HttpServletResponse.SC_UNAUTHORIZED, "授权失败，禁止访问", Boolean.FALSE);
        res.getWriter().println(objectMapper.writeValueAsString(result));
    }
}
