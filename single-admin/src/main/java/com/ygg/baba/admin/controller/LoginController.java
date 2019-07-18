package com.ygg.baba.admin.controller;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ygg.baba.admin.common.constants.ErrorCode;
import com.ygg.baba.admin.common.util.TreeUtil;
import com.ygg.baba.admin.config.SecurityConfig;
import com.ygg.baba.admin.model.dto.MenuTree;
import com.ygg.baba.admin.model.entity.Menu;
import com.ygg.baba.admin.model.entity.User;
import com.ygg.baba.admin.security.AuthManager;
import com.ygg.baba.admin.security.CustomConcurrentSessionControlAuthenticationStrategy;
import com.ygg.baba.admin.service.SysMenuService;
import com.ygg.baba.common.annotation.RequestRequire;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.exception.BusinessException;
import com.ygg.baba.common.util.R;
import com.ygg.baba.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "auth")
@Api(description = "登陆", tags = "登陆")
public class LoginController extends BaseController {

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private CustomConcurrentSessionControlAuthenticationStrategy strategy;

    @ApiOperation(value = "登陆", notes = "username,password", response = Map.class)
    @RequestRequire(require = "username,password", parameter = Map.class)
    @PostMapping("/login")
    public R<Map> login(@RequestBody Map<String, Object> logMap) {
        String loginId = logMap.get("username").toString();
        String password = logMap.get("password").toString();
        log.info(session.getId());
        //正则loginId是否为手机号码

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginId, password);
        try {
            Authentication authentication = securityConfig.authenticationManagerBean().authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            strategy.onAuthentication(authentication, httpServletRequest, httpServletResponse);
            Map<String, Object> hashMap = Maps.newHashMap();

            //获取权限菜单
            User user = AuthManager.getUser();

            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>用户登录成功！用户ID：{},请求地址：{}<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", user.getUserId(), httpServletRequest.getRemoteHost());
            hashMap.put("id", user.getUserId());
            hashMap.put("username", user.getUsername());
            return new R<>(hashMap, "用户登录成功");
        } catch (AuthenticationException e) {
            log.error("", e);
            if (e.getMessage() == null) return new R<>(ErrorCode.USERNAME_NULL.getCode());
            AuthManager.logout(httpServletRequest, httpServletResponse);
            return new R<>(ErrorCode.LOGIN_ERROR.getCode(), "登陆失败,请检查用户名密码是否正确");
        } catch (Exception e) {
            log.error("", e);
            return new R<>(e);
        }
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public R<Boolean> logout() {
        AuthManager.logout(httpServletRequest, httpServletResponse);
        return new R<>(true);
    }


    /**
     * 修改密码
     *
     * @param
     */
    @ApiOperation(value = "修改密码", notes = "newPwd/oldPwd", responseContainer = "R")
    @GetMapping("/modifyPwd")
    protected R<Boolean> modifyPwd(@RequestParam String password, @RequestParam String newPassword) {
        return new R<>(true);
    }

    @ApiOperation(value = "查询菜单", notes = "查询用户菜单，支持n级")
    @GetMapping("/menuTree")
    public R<List> menuTree() {
        try {
            AuthManager.getUser();
        } catch (Exception e) {
            throw new BusinessException("请先登录");
        }

        List<GrantedAuthority> grantedAuthorityList = (List<GrantedAuthority>) AuthManager.getUser().getAuthorities();

        Set<Menu> all = new HashSet<>();
        grantedAuthorityList.forEach(n -> all.addAll(sysMenuService.findMenuByRoleName(n.getAuthority())));
        List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach(menu -> {
            if (CommonConstant.MENU.equals(menu.getType())) {
                menuTreeList.add(new MenuTree(menu));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        return new R<>(TreeUtil.bulid(menuTreeList, -1));
    }

    @ApiOperation(value = "查询所有菜单", notes = "查询所有菜单，支持n级")
    @GetMapping("/allMenuTree/{onlyMenu}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public R<List> allMenuTree(@PathVariable Boolean onlyMenu) {
        Integer loginId = AuthManager.getUserId();

        Set<Menu> allMenu = null;
        if (loginId == 1) {
            allMenu = sysMenuService.findMenuAll(Maps.newHashMap());
        } else allMenu = sysMenuService.findMenuByUserId(loginId);

        List<MenuTree> menuTreeList = Lists.newArrayList();

        allMenu.forEach(menu -> {
            if (CommonConstant.MENU.equals(menu.getType()) || !onlyMenu) {
                menuTreeList.add(new MenuTree(menu));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        return new R<>(TreeUtil.buildByRecursive(menuTreeList, -1));
    }

}
