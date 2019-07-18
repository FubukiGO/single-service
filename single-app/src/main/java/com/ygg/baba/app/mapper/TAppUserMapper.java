package com.ygg.baba.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygg.baba.app.model.dto.AuthUser;
import com.ygg.baba.app.model.entity.TAppUser;
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
