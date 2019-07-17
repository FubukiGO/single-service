package com.ygg.debt.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.ygg.debt.admin.model.entity.SysUser;
import com.ygg.debt.admin.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * @param username
     * @return User
     * @author akhan
     * @description 根据用户名查询user
     * @date 上午10:22 2018/8/14
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * @param mobile
     * @return User
     * @author akhan
     * @description 根据手机号查询user
     * @date 上午10:22 2018/8/14
     */
    User selectUserByMobile(@Param("mobile") String mobile);

    /**
     * @param page
     * @param params
     * @return
     */
    List<User> selectUserPage(Pagination page, @Param("n") Map params);
}
