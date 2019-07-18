package com.ygg.baba.admin.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ygg.baba.admin.model.dto.SysRoleDto;
import com.ygg.baba.admin.model.entity.Menu;
import com.ygg.baba.admin.model.entity.SysRole;
import com.ygg.baba.admin.model.entity.SysRoleMenu;
import com.ygg.baba.admin.security.AuthManager;
import com.ygg.baba.admin.service.SysMenuService;
import com.ygg.baba.admin.service.SysRoleMenuService;
import com.ygg.baba.admin.service.SysRoleService;
import com.ygg.baba.common.annotation.RequestRequire;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.util.Query;
import com.ygg.baba.common.util.R;
import com.ygg.baba.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@RestController
@RequestMapping("sysUserRole")
@Api(description = "用户角色管理", tags = "用户角色管理")
public class SysUserRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @PostMapping("/rolePage")
    @ApiOperation(value = "获取角色列表", notes = "", response = Boolean.class)
    public R rolePage(@RequestBody Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        IPage<SysRoleDto> r = sysRoleService.findPage(new Query<>(params), params);
        r.getRecords().forEach(n -> {
            Set<Menu> menus = new HashSet<>();
            menus.addAll(sysMenuService.findMenuByRoleName(n.getAuthority()));
            n.setMenuIds(menus.stream().filter(m -> isChildOnly(menus, m)).map(Menu::getMenuId).collect(Collectors.toList()));
        });
        return new R<>(r);
    }

    /**
     * 添加
     *
     * @param sysRoleDto 实体
     * @return success/false
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "新增角色、限制日期、菜单权限", notes = "", response = SysRoleDto.class)
    public R<Boolean> add(@RequestBody SysRoleDto sysRoleDto) {
        Integer loginId = AuthManager.getUserId();
        Date now = new Date();
        sysRoleDto.setRoleCode("ROLE_" + RandomStringUtils.random(10, false, true));
        sysRoleDto.setCreateTime(now);
        sysRoleDto.setModifiedTime(now);


        SysRole role = new SysRole();
        BeanUtils.copyProperties(sysRoleDto, role);
        role.setDelFlag(CommonConstant.STATUS_NORMAL);
        role.setInsUserId(loginId);

        sysRoleService.save(role);

        if (CollectionUtil.isNotEmpty(sysRoleDto.getMenuIds())) {
            sysRoleMenuService.insertRoleMenus(role.getRoleId(), sysRoleDto.getMenuIds());
        }
        return new R<>(Boolean.TRUE);
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除角色", notes = "", response = SysRoleDto.class)
    public R<Boolean> delete(@PathVariable Integer id) {

        if (sysRoleService.beforeDelete(id)) {
            SysRole sysRole = new SysRole();

            sysRole.setDelFlag("1");

            sysRoleService.update(sysRole, Wrappers.<SysRole>query().eq("role_id", id));
        } else return new R<>(false, "该用户组下还有未删除的用户，请删除后重试");
        return new R<>(true);
    }

    /**
     * 编辑
     *
     * @param sysRoleDto 实体
     * @return success/false
     */
    @PutMapping
    @Transactional
    @RequestRequire(parameter = SysRoleDto.class, require = "roleId")
    @ApiOperation(value = "修改角色、菜单权限", notes = "", response = SysRoleDto.class)
    public R<Boolean> edit(@RequestBody SysRoleDto sysRoleDto) {
        Date now = new Date();
        sysRoleDto.setCreateTime(null);
        sysRoleDto.setModifiedTime(now);
        SysRole role = new SysRole();
        BeanUtils.copyProperties(sysRoleDto, role);
        sysRoleService.update(role, Wrappers.<SysRole>query().eq("role_id", role.getRoleId()));
        if (CollectionUtil.isNotEmpty(sysRoleDto.getMenuIds())) {
            sysRoleMenuService.insertRoleMenus(role.getRoleId(), sysRoleDto.getMenuIds());
        }


        return new R<>(Boolean.TRUE);
    }

    /**
     * @author akhan
     * @description 查看指定角色菜单id
     * @date 10:09 AM 2018/10/16
     */
    @GetMapping("/findMenuIds/{roleId}")
    @ApiOperation(value = "查看指定角色菜单", notes = "传角色id")
    public R findMenuIds(@PathVariable Integer roleId) {
        return new R<>(sysRoleMenuService.list(Wrappers.<SysRoleMenu>query().eq("role_id", roleId)).stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList()));
    }

    /**
     * 更新角色菜单
     *
     * @param sysRole
     * @return success、false
     */
    @Transactional
    @PutMapping("/roleMenuUpd")
    @ApiOperation(value = "更新角色菜单", notes = "roleId,menuIds[]", response = Boolean.class)
    //前端不会调啊 我有什么办法
    //public R<Boolean> roleMenuUpd(Integer roleId, @RequestParam("menuIds[]") List<Integer> menuIds) {
    @RequestRequire(require = "roleId", parameter = SysRoleDto.class)
    public R<Boolean> roleMenuUpd(@RequestBody SysRoleDto sysRole) {
        return new R<>(sysRoleMenuService.insertRoleMenus(sysRole.getRoleId(), sysRole.getMenuIds()));
    }

    boolean isChildOnly(Set<Menu> list, Menu menu) {
        for (Menu m : list) {
            if (m.getParentId().equals(menu.getMenuId())) {
                return false;
            }
        }
        return true;
    }

}
