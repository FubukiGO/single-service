package com.ygg.wx.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ygg.wx.admin.model.entity.TAppUser;
import com.ygg.wx.admin.model.vo.AppUserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * H5   用户表 服务类
 * </p>
 *
 * @author baba
 * @since 2018-09-25
 */
public interface ITAppUserService extends IService<TAppUser>, UserDetailsService {


    AppUserVo login(String phone, String pwd, String ip);

    AppUserVo loginByCheckcode(String phone, String checkcode);

}
