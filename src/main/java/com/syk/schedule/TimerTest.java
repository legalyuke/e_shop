package com.syk.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author liyuke
 * @date 2021-04-20 16:58
 */
@Slf4j
@Component
public class TimerTest {
    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {
        log.info("这是一个定时任务");
    }
}
