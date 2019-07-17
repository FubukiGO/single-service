package com.ygg.debt.admin.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author akhan
 * @description
 * @date 下午4:33 2018/6/19
 */
@Slf4j
@Component
public class TaskScheduler {

    @Scheduled(cron = "0 0 1 * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void invokeBuyTimeOut() {
        log.info("hello");
    }
}