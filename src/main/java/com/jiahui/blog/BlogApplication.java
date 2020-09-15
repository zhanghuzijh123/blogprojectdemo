package com.jiahui.blog;

import com.jiahui.blog.utils.SnowflakeIdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }

    @Bean
    public SnowflakeIdWorker createIdWorker(){
        return new SnowflakeIdWorker(0,0);
    }
}
