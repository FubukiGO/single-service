package com.ygg.baba.common.support;

import com.ygg.baba.common.constants.MqQueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author akhan
 * @description rabbitmq配置
 * @date 11:14 2018-12-25
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue initPushMsgQueue() {
        return new Queue(MqQueueConstant.PUSH_MSG);
    }

    @Bean
    public Queue initIssueCouponQueue() {
        return new Queue(MqQueueConstant.ISSUE_COUPON);
    }

    @Bean
    public Queue initUpLoadLoansFileQueue() {
        return new Queue(MqQueueConstant.UPLOAD_LOANS_FILE);
    }

    @Bean
    public Queue initSyncOrderEvidenceQueue() {
        return new Queue(MqQueueConstant.SYNC_ORDER_EVIDENCE);
    }

    @Bean
    public Queue initNoticeProcessor() {
        return new Queue(MqQueueConstant.NOTICE_PROCESSOR);
    }
}
