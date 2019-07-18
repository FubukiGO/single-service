package com.ygg.baba.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: akhan
 * @Description:
 * @Date: 11:08 2019-02-22
 */
@Scope("prototype")
@Component
@Configuration
@ConfigurationProperties("payserver.alipay")
public class AlipayConfig {
    private String merchantId,
            privateKey,
            publicKey,
            notifyUrl,
            appPublicKey;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getAppPublicKey() {
        return appPublicKey;
    }

    public AlipayConfig setAppPublicKey(String appPublicKey) {
        this.appPublicKey = appPublicKey;
        return this;
    }
}
