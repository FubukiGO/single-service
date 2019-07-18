package com.ygg.baba.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.admin.mapper.SysUserMapper;
import com.ygg.baba.admin.model.entity.SysUser;
import com.ygg.baba.admin.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    /**
     * @param page
     * @param params
     * @author akhan
     * @description
     * @date 下午3:09 2018/8/16
     */
    @Override
    public IPage selectUserPage(Page page, Map params) {
        return baseMapper.selectUserPage(page, params);
    }
}
