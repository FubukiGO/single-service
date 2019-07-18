package com.ygg.baba.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author akhan
 * @description
 * @date 14:40 2018-12-21
 */
@Data
@Component
@ConfigurationProperties("evi")
public class EvidenceConfig {
    private String uploadUrl;
    private String busId;
    private String sceneId;
}
