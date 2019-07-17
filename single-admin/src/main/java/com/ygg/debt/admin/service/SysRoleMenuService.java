package com.ygg.debt.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ygg.debt.admin.model.entity.SysRoleMenu;
import com.ygg.debt.common.util.R;

import java.util.List;

/**
 * <p>
 * 角色菜单表 服务类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 更新角色菜单
     *
     * @param roleId  角色
     * @param menuIds 菜单列表
     * @return
     */
    Boolean insertRoleMenus(Integer roleId, List<Integer> menuIds);

    R saveOrUpdateRoleMenus(Integer roleId, List<Integer> ids);
}
