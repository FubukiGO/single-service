package com.ygg.wx.admin.config;

import com.ygg.debt.common.constants.CommonConstant;
import com.ygg.debt.common.util.HttpHelper;
import com.ygg.wx.admin.common.util.JwtTokenUtils;
import com.ygg.wx.admin.common.util.StringUtils;
import com.ygg.wx.admin.model.dto.AuthUser;
import com.ygg.wx.admin.service.ITAppUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author akhan
 * @description
 * @date 18:04 2018-11-22
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyyMMdd");

    @Autowired
    private ITAppUserService appUserService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader(CommonConstant.REQ_HEADER);
        if (token != null && token.startsWith(CommonConstant.TOKEN_SPLIT)) {
            token = StringUtils.substringAfter(token, CommonConstant.TOKEN_SPLIT);

            String phone = jwtTokenUtils.getPhoneFromToken(token);

            if (phone != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails login = appUserService.loadUserByUsername(phone);
                ((AuthUser) login).setClientIp(HttpHelper.getRemoteHost(httpServletRequest));
                if (jwtTokenUtils.validateToken(token, login)) {
                    Date now = new Date();
                    Integer loginId = ((AuthUser) login).getId();
                    log.info("-----当前登陆用户: {}-----", login);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, null, login.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
