package com.ygg.debt.admin.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ygg.debt.admin.model.entity.SysUser;
import com.ygg.debt.admin.model.entity.User;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * @author akhan
     * @description
     * @date 下午3:09 2018/8/16
     */
    Page<User> selectUserPage(Page<User> page, Map params);
}
