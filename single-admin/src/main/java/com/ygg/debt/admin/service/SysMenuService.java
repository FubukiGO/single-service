package com.ygg.debt.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ygg.debt.admin.model.entity.Menu;
import com.ygg.debt.admin.model.entity.SysMenu;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author baba
 * @since 2018-08-13
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * @param role
     * @author akhan
     * @description 通过权限字符串查询菜单
     * @date 下午2:06 2018/8/14
     */
    Set<Menu> findMenuByRoleName(String role);

    /**
     * @param userId
     * @author akhan
     * @description 通过用户id查询菜单
     * @date 下午2:06 2018/8/14
     */
    Set<Menu> findMenuByUserId(Integer userId);

    /**
     * @param param
     * @Author: akhan
     * @Description: 查询所有菜单
     * @Date: 15:18 2019-02-18
     */
    Set<Menu> findMenuAll(Map param);

    /**
     * 更新角色菜单
     *
     * @param menu
     * @return
     */
    Boolean updateMenuById(SysMenu menu);

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    Boolean addMenu(SysMenu menu);
}
