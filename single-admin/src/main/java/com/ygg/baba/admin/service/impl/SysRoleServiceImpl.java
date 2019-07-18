package com.ygg.baba.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.admin.mapper.SysRoleMapper;
import com.ygg.baba.admin.model.entity.SysRole;
import com.ygg.baba.admin.service.SysRoleService;
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
    public IPage findPage(Page page, Map params) {
        return baseMapper.findPage(page, params);
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
