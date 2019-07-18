package com.ygg.baba.admin.service.impl;

import com.ygg.baba.admin.mapper.SysUserMapper;
import com.ygg.baba.admin.service.AdminUserService;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baba
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String s) {
        return sysUserMapper.selectUserByUsername(s);
    }

}
