package com.ygg.baba.app.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.ygg.baba.app.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author akhan
 * @description
 * @date 下午7:16 2018/8/14
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

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

        if (principal != null) {
            if (CollectionUtil.isEmpty(grantedAuthorityList)) {
                log.warn("当前用户未拥有角色:{}", principal);
                return hasPermission;
            }
        }
        return hasPermission;
    }
}
