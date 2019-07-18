package com.ygg.baba.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.admin.common.constants.ErrorCode;
import com.ygg.baba.admin.mapper.SysRoleMenuMapper;
import com.ygg.baba.admin.model.entity.SysRoleMenu;
import com.ygg.baba.admin.service.SysRoleMenuService;
import com.ygg.baba.common.util.R;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色菜单表 服务实现类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    public Boolean insertRoleMenus(Integer roleId, List<Integer> menuIds) {
        SysRoleMenu condition = new SysRoleMenu();
        condition.setRoleId(roleId);
        this.remove(Wrappers.<SysRoleMenu>query(condition));

        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        for (Integer menuId : menuIds) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);
        }
        return this.saveBatch(roleMenuList);
    }

    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    public R saveOrUpdateRoleMenus(Integer roleId, List<Integer> ids) {
        baseMapper.delRoleMenusByRoleId(roleId);
        SysRoleMenu sysRoleMenu = null;
        for (Integer id : ids) {
            sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(id);
            baseMapper.insert(sysRoleMenu);
        }
        return new R(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getDesc());
    }
}
