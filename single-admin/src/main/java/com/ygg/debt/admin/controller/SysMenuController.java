package com.ygg.debt.admin.controller;

import com.google.common.collect.Lists;
import com.xiaoleilu.hutool.collection.CollUtil;
import com.ygg.debt.admin.common.util.TreeUtil;
import com.ygg.debt.admin.model.dto.MenuTreeAC;
import com.ygg.debt.admin.model.entity.Menu;
import com.ygg.debt.admin.model.entity.SysMenu;
import com.ygg.debt.admin.service.SysMenuService;
import com.ygg.debt.admin.service.SysRoleMenuService;
import com.ygg.debt.common.annotation.RequestRequire;
import com.ygg.debt.common.constants.CommonConstant;
import com.ygg.debt.common.util.R;
import com.ygg.debt.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: akhan
 * @Description: 系统菜单 控制器
 * @Date: 14:54 2019-02-18
 */
@RestController
@RequestMapping("sys_menu")
@Api(description = "系统菜单管理", tags = "系统菜单管理")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @PostMapping("page")
    @ApiOperation(value = "查询所有菜单", notes = "选传name, beginTime, endTime", response = Menu.class)
    public R<List> page(@RequestBody Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);

        Set<Menu> allMenu = sysMenuService.findMenuAll(params);

        List<MenuTreeAC> menuTreeList = Lists.newArrayList();

        allMenu.forEach(menu -> menuTreeList.add(new MenuTreeAC(menu)));
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTreeAC::getSort));
        return new R<>(TreeUtil.buildByRecursive(menuTreeList, -1));
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "新增菜单", notes = "parentId,name 必传")
    @RequestRequire(parameter = SysMenu.class, require = "parentId,name")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R add(@RequestBody SysMenu menu) {
        Date now = new Date();

        menu.setDelFlag(CommonConstant.STATUS_NORMAL);
        menu.setCreateTime(now);
        menu.setUpdateTime(now);

        return new R<>(sysMenuService.addMenu(menu));
    }

    @PutMapping
    @ApiOperation(value = "修改菜单", notes = "id 必传")
    @RequestRequire(parameter = SysMenu.class, require = "id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R edit(@RequestBody SysMenu menu) {
        Date now = new Date();

        menu.setMenuId(menu.getId());
        menu.setDelFlag(CommonConstant.STATUS_NORMAL);
        menu.setCreateTime(null);
        menu.setUpdateTime(now);

        return new R<>(sysMenuService.updateMenuById(menu));
    }

    @DeleteMapping("/{menuId}")
    @ApiOperation(value = "删除菜单", notes = "id 必传")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R delete(@PathVariable Integer menuId) {
        Date now = new Date();

        SysMenu menu = new SysMenu();
        menu.setMenuId(menuId);
        menu.setDelFlag(CommonConstant.STATUS_DEL);

        menu.setUpdateTime(now);
        return new R<>(sysMenuService.updateMenuById(menu));
    }

}
