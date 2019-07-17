package com.ygg.debt.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ygg.debt.admin.mapper.SysRoleMapper;
import com.ygg.debt.admin.model.dto.SysRoleDto;
import com.ygg.debt.admin.model.entity.SysRole;
import com.ygg.debt.admin.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * @param page
     * @param params
     * @author akhan
     * @description 分页查询
     * @date 下午4:13 2018/8/16
     */
    @Override
    public Page<SysRoleDto> findPage(Page<SysRoleDto> page, Map params) {
        return page.setRecords(baseMapper.findPage(page, params));
    }

    /**
     * 检查角色下是否还有用户
     *
     * @param roleId
     * @return
     */
    @Override
    public boolean beforeDelete(Integer roleId) {
        return baseMapper.beforeDelete(roleId) == 0;
    }

    @Override
    public List<SysRole> findRoleByUserId(Integer userId) {
        return baseMapper.findRoleByUserId(userId);
    }
}
