package com.ygg.baba.app.service;


import com.ygg.baba.app.model.dto.UserTokenDto;
import com.ygg.baba.app.model.entity.TAppUser;

public interface BaseApiService {

    UserTokenDto getToken(String token);

    String refreshToken(TAppUser appUser);
}
