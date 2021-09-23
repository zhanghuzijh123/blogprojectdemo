package com.jiahui.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplateConfig
 *
 * @author Administrator
 * @date 2021/9/18 0018
 */
@Slf4j
@Service
public class RedisTemplateConfig {
    /**
     * redis缓存
     */
    private final RedisTemplate<String, String> redisTemplate;

    /**
     * 注入
     * @param redisTemplate 模板
     */
    public RedisTemplateConfig(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean addSetRedis(String key,Set<String> stringSet,Integer time){
        try {
            //通过ValueOperations设置值
            SetOperations setOps = redisTemplate.opsForSet();
            String[] strings = stringSet.toArray(new String[0]);
            setOps.add(key, strings);
            redisTemplate.expire(key,time,TimeUnit.MINUTES);
            return true;
        }catch (Exception e){
            log.error("添加set缓存失败!");
            return false;
        }

    }

    public Set getSetRedis(String key){
        try {
            //通过ValueOperations获取值
            SetOperations setOps = redisTemplate.opsForSet();
            Set set = setOps.members(key);
            return set;
        }catch (Exception e){
            log.error("获取set缓存失败!");
            return null;
        }
    }
}