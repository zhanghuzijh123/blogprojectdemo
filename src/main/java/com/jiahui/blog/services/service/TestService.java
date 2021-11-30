package com.jiahui.blog.services.service;

import com.jiahui.blog.config.RedisTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * 添加set缓存
     * @return
     */
    public Boolean addSet(){
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
            redisTemplateConfig.addSet(key,set);
//            redisTemplateConfig.addSetRedis(key,set,5);
            return true;
        }catch (Exception e){
            log.error("添加set缓存失败!");
            return false;
        }

    }

    /**
     * 添加set缓存
     * @return
     */
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

    /**
     * 获取set缓存
     * @return
     */
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

    public Boolean addRedisString() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("hashmap1", "111");
        hashMap.put("hashmap2", "222");
        hashMap.put("hashmap3", "333");
        String key = "hashKey";
        Boolean result = redisTemplateConfig.addHashMap(key, hashMap);
        return result;
    }

    public Boolean addRedisStringByTime() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("hashmap4", "444");
        hashMap.put("hashmap5", "555");
        hashMap.put("hashmap6", "666");
        String key = "hashMapKey";
        Boolean result = redisTemplateConfig.addHashMapByTime(key, hashMap, 5);
        return result;
    }

    public Map getHashMap() {
        String key = "hashKey";
        Map hashMap = redisTemplateConfig.getHashMap(key);
        System.out.println(11111);
        return hashMap;
    }

    public Boolean addString(){
        String key = "stringKey";
        String value = "stringValue";
        Boolean result = redisTemplateConfig.addString(key, value);
        String key1 = "stringKey1";
        String value1 = "stringValue1";
        redisTemplateConfig.addStringByTime(key1,value1,1);
        return result;
    }

    public String getString(){
        String key = "stringKey";
        String string = redisTemplateConfig.getString(key);
        return string;
    }
}
