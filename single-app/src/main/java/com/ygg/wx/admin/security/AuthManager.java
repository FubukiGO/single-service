package com.ygg.wx.admin.security;

import com.ygg.wx.admin.model.dto.AuthUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
    public static AuthUser getUser() {
        return (AuthUser) getAuthentication().getPrincipal();
    }


    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Authentication getAuthentication() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户NAME
     *
     * @return
     */
    public static String getName() {
        return getUser().getName();
    }

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Integer getUserId() {
        return getUser().getId();
    }

    /**
     * 判断是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    public static boolean isUserRole() {
        for (GrantedAuthority r : SecurityContextHolder.getContext().getAuthentication().getAuthorities())
            if (StringUtils.equals(r.getAuthority(), "ROLE_USER")) {
                return true;
            }
        return false;
    }

    public static void logout(HttpServletRequest req, HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            new SecurityContextLogoutHandler().logout(req, res, auth);
    }

}
