package com.ygg.debt.admin.service.impl;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.xiaoleilu.hutool.collection.CollUtil;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.ygg.debt.admin.model.entity.Menu;
import com.ygg.debt.admin.security.AuthManager;
import com.ygg.debt.admin.service.PermissionService;
import com.ygg.debt.admin.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author akhan
 * @description
 * @date 下午7:16 2018/8/14
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysMenuService sysMenuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        boolean hasPermission = false;

        Object principal = authentication.getPrincipal();
        List<GrantedAuthority> grantedAuthorityList = (List<GrantedAuthority>) authentication.getAuthorities();

        try {
            log.info("当前登陆用户id: {}", AuthManager.getUserId());

        } catch (Exception e) {
        }

        if (principal != null) {
            if (CollectionUtil.isEmpty(grantedAuthorityList)) {
                log.warn("当前用户未拥有角色:{}", principal);
                return hasPermission;
            }

            Set<Menu> urls = new HashSet<>();
            for (GrantedAuthority authority : grantedAuthorityList) {
                Set<Menu> menuVOSet = sysMenuService.findMenuByRoleName(authority.getAuthority());
                if (CollUtil.isNotEmpty(menuVOSet)) {
                    CollUtil.addAll(urls, menuVOSet);
                }
            }
            for (Menu menu : urls) {
                if (StringUtils.isNotEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
