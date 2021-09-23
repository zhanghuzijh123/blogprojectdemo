package com.jiahui.blog.job;

import com.jiahui.blog.config.ScheduleStartConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class TimeTaskJob {
    @Resource
    private ScheduleStartConfig scheduleStartConfig;

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void timeTask(){
        if (scheduleStartConfig.isEnable()) {
            System.out.println("定时任务开启");
        }
    }
}
