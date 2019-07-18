package com.ygg.baba.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygg.baba.admin.model.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色菜单表 Mapper 接口
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    void delRoleMenusByRoleId(@Param("roleId") Integer roleId);

}
