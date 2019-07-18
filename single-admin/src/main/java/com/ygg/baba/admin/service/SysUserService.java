package com.ygg.baba.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ygg.baba.admin.model.entity.SysUser;
import com.ygg.baba.admin.model.entity.User;

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
    IPage<User> selectUserPage(Page page, Map params);
}
