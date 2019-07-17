package com.ygg.debt.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ygg.debt.admin.mapper.SysUserMapper;
import com.ygg.debt.admin.model.entity.SysUser;
import com.ygg.debt.admin.model.entity.User;
import com.ygg.debt.admin.service.SysUserService;
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
    public Page<User> selectUserPage(Page<User> page, Map params) {
        return page.setRecords(baseMapper.selectUserPage(page, params));
    }
}
