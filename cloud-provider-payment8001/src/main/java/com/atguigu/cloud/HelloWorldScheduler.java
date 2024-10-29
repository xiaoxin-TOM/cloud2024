package com.atguigu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloWorldScheduler {

    // 使用 cron 表达式来定义每分钟执行一次任务
    @Scheduled(cron = "0 * * * * *")
    public void printHelloWorld() {
        log.info("输出了定时任务");
        log.info("Hello, world!");
    }
}