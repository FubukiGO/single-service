package com.ygg.baba.app.listener;

import com.ygg.baba.app.service.ITAppUserService;
import com.ygg.baba.common.constants.MqQueueConstant;
import com.ygg.baba.common.model.dto.PushMsgDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author akhan
 * @description
 * @date 11:20 2018-12-25
 */
@Slf4j
@Component
@RabbitListener(queues = MqQueueConstant.PUSH_MSG)
public class PushMsgReceiveListener {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ITAppUserService appUserService;

    @RabbitHandler
    public void handler(PushMsgDto msg) {
        log.info("MQ Message Listener executing....");
        log.info("execute finish!");
    }
}
