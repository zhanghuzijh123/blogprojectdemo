package com.jiahui.blog;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.jiahui.blog.utils.SnowflakeIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@MapperScan(basePackages = {"com.jiahui.blog.mapper"})
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }

    @Bean
    public SnowflakeIdWorker createIdWorker(){
        return new SnowflakeIdWorker(0,0);
    }

    @Bean
    public BCryptPasswordEncoder createPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
