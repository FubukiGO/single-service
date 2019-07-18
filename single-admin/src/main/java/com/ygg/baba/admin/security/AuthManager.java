package com.ygg.baba.admin.security;

import com.ygg.baba.admin.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthManager {
    private static final Logger logger = LoggerFactory.getLogger(AuthManager.class);

    /**
     * 获取当前登录的用户User对象
     *
     * @return
     */
    public static User getUser() {
        User u = (User) getAuthentication().getPrincipal();
        logger.info("=====当前登陆用户:{}=====", u);
        return u;
    }


    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户NAME
     *
     * @return
     */
    public static String getName() {
        return getUser().getUsername();
    }

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Integer getUserId() {
        return getUser().getUserId();
    }

    /**
     * 判断是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    public static void logout(HttpServletRequest req, HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            new SecurityContextLogoutHandler().logout(req, res, auth);
    }

}
