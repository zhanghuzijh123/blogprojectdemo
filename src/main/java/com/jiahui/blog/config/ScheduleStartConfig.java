package com.jiahui.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ScheduleStartConfig
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Configuration
@ConfigurationProperties(prefix = "schedule")
@Getter
@Setter
public class ScheduleStartConfig {
    /**
     * 是否开启定时任务
     */
    private boolean enable;
}
