package com.ygg.wx.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ygg.wx.admin.model.dto.AuthUser;
import com.ygg.wx.admin.model.entity.TAppUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * H5   用户表 Mapper 接口
 * </p>
 *
 * @author baba
 * @since 2018-09-25
 */
public interface TAppUserMapper extends BaseMapper<TAppUser> {

    AuthUser selectUserByUsername(@Param("username") String userName);
}
