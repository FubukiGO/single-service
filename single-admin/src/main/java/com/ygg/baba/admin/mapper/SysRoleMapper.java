package com.ygg.baba.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ygg.baba.admin.model.dto.SysRoleDto;
import com.ygg.baba.admin.model.entity.SysRole;
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
    IPage<List<SysRoleDto>> findPage(Page page, @Param("n") Map params);

    int beforeDelete(@Param("roleId") Integer roleId);

    List<SysRole> findRoleByUserId(@Param("userid") Integer userId);
}
