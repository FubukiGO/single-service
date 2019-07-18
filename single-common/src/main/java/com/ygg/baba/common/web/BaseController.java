package com.ygg.baba.common.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BaseController {

    @Autowired
    protected HttpServletRequest httpServletRequest;

    @Autowired
    protected HttpServletResponse httpServletResponse;

    @Autowired
    protected HttpSession session;


    /**
     * 获取 请求来源
     *
     * @return
     */
    protected String getSource() {
        return StringUtils.isEmpty(httpServletRequest.getHeader("source")) ? "OTHER" : httpServletRequest.getHeader("source").toUpperCase();
    }

}
