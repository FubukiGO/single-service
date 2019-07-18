package com.ygg.baba.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author akhan
 * @description 微信支持 参数
 * @date 18:11 2019-01-08
 */
@Data
@Component
@ConfigurationProperties("baba")
public class WxSupportConfig {

    //允许的url
    private String host;
    //获取令牌地址
    private String accessTokenUrl;
    //获取凭证地址
    private String ticketUrl;
    //应用id
    private String appId;
    //应用密钥
    private String appSecret;
}
