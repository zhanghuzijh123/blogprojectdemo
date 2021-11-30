package com.jiahui.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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
     *
     * @param redisTemplate 模板
     */
    public RedisTemplateConfig(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 添加redis缓存set类型
     *
     * @param key
     * @param stringSet
     * @return
     */
    public Boolean addSet(String key, Set<String> stringSet) {
        try {
            SetOperations setOps = redisTemplate.opsForSet();
            String[] strings = stringSet.toArray(new String[0]);
            setOps.add(key, strings);
            return true;
        } catch (Exception e) {
            log.error("添加set类型的redis缓存失败!" + e);
            return false;
        }
    }

    /**
     * 添加redis缓存set类型，time过期时间
     *
     * @param key
     * @param stringSet
     * @param time
     * @return
     */
    public Boolean addSetRedis(String key, Set<String> stringSet, Integer time) {
        try {
            //通过ValueOperations设置值
            SetOperations setOps = redisTemplate.opsForSet();
            String[] strings = stringSet.toArray(new String[0]);
            setOps.add(key, strings);
            redisTemplate.expire(key, time, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("添加set缓存失败!" + e);
            return false;
        }
    }

    /**
     * 通过key获取value值
     *
     * @param key
     * @return
     */
    public Set getSetRedis(String key) {
        try {
            //通过ValueOperations获取值
            SetOperations setOps = redisTemplate.opsForSet();
            Set set = setOps.members(key);
            return set;
        } catch (Exception e) {
            log.error("获取set缓存失败!" + e);
            return null;
        }
    }

    /**
     * 添加hashmap类型的redis
     *
     * @param key
     * @param hashMap
     * @return
     */
    public Boolean addHashMap(String key, HashMap<String, String> hashMap) {
        try {
            HashOperations hashOps = redisTemplate.opsForHash();
            hashMap.entrySet().forEach(i -> {
                hashOps.put(key, i.getKey(), i.getValue());
            });
//            hashOps.put(key, hashKey, hashValue);
            return true;
        } catch (Exception e) {
            log.error("添加hashmap类型的redis缓存失败!" + e);
            return false;
        }
    }

    /**
     * 添加hashmap类型的redis，并且设置过期时间
     *
     * @param key
     * @param hashMap
     * @param time
     * @return
     */
    public Boolean addHashMapByTime(String key, HashMap<String, String> hashMap, Integer time) {
        try {
            HashOperations hashOps = redisTemplate.opsForHash();
            hashMap.entrySet().forEach(i -> {
                hashOps.put(key, i.getKey(), i.getValue());
            });
            redisTemplate.expire(key, time, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("添加hashmap类型的redis缓存失败!" + e);
            return false;
        }
    }

    /**
     * 获取hashmap类型的redis
     *
     * @param key
     * @return
     */
    public Map<String, String> getHashMap(String key) {
        try {
            //通过ValueOperations获取值
            HashOperations hashOps = redisTemplate.opsForHash();
            Map<String, String> map = hashOps.entries(key);
            return map;
        } catch (Exception e) {
            log.error("获取hashmap缓存失败!" + e);
            return null;
        }
    }

    /**
     * 添加string类型的redis缓存
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean addString(String key, String value) {
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(key, value);
            return true;
        } catch (Exception e) {
            log.error("添加String类型的redis缓存失败!" + e);
            return false;
        }
    }

    /**
     * 添加string类型的redis缓存，并设置过期时间
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public Boolean addStringByTime(String key, String value, Integer time) {
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(key, value, 1, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("添加String类型的redis缓存失败!" + e);
            return false;
        }
    }

    /**
     * 获取String类型的redis缓存
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            String str = (String) ops.get(key);
            return str;
        } catch (Exception e) {
            log.error("获取String缓存失败!" + e);
            return null;
        }
    }
}