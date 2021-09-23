package com.jiahui.blog.services.service;

import com.jiahui.blog.config.RedisTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * TestService
 *
 * @author Administrator
 * @date 2021/9/23 0023
 */
@Slf4j
@Service
public class TestService {
    @Resource
    private RedisTemplateConfig redisTemplateConfig;


    public Boolean addSetRedis(){
        try {
            Set<String> set = new HashSet<>();
            set.add("111111");
            set.add("222222");
            set.add("111111");
            set.add("333333");
            set.add("444444");
            set.add("111111");
            System.out.println(set);
            String key = "setKey";
            redisTemplateConfig.addSetRedis(key,set,5);
            return true;
        }catch (Exception e){
            log.error("添加set缓存失败!");
            return false;
        }

    }

    public Boolean getRedisSet(){
        try {
            String key = "setKey";
            Set setRedis = redisTemplateConfig.getSetRedis(key);
            System.out.println(111111);
            return true;
        }catch (Exception e){
            log.error("获取set类型redis失败!"+e);
            return false;
        }
    }
}
