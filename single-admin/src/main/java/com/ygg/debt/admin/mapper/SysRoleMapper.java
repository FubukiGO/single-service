package com.ygg.debt.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.ygg.debt.admin.model.dto.SysRoleDto;
import com.ygg.debt.admin.model.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRoleDto> findPage(Pagination page, @Param("n") Map params);

    int beforeDelete(@Param("roleId") Integer roleId);

    List<SysRole> findRoleByUserId(@Param("userid") Integer userId);
}
