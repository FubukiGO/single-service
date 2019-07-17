package com.ygg.wx.admin.service;


import com.ygg.wx.admin.model.dto.UserTokenDto;
import com.ygg.wx.admin.model.entity.TAppUser;

public interface BaseApiService {

    UserTokenDto getToken(String token);

    String refreshToken(TAppUser appUser);
}
