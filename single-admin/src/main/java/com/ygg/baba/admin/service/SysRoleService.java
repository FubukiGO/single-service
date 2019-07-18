package com.ygg.baba.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ygg.baba.admin.model.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baba
 * @since 2018-08-13
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * @author akhan
     * @description 分页查询
     * @date 下午4:13 2018/8/16
     */
    IPage findPage(Page page, Map params);

    /**
     * 检查角色下是否还有用户
     *
     * @param roleId
     * @return
     */
    boolean beforeDelete(@Param("roleId") Integer roleId);

    List<SysRole> findRoleByUserId(Integer userId);
}
