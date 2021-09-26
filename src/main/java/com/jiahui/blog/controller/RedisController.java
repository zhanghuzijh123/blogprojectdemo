package com.jiahui.blog.controller;

import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.services.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * RedisController
 *
 * @author Administrator
 * @date 2021/9/23 0023
 */
@RestController
@Slf4j
@RequestMapping("/redis/test")
public class RedisController {
    @Resource
    private TestService testService;

    @GetMapping("/set/add")
    public ResponseResult addRedisToSet(){
        try {
            return ResponseResult.SUCCESS().setData(testService.addSet());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/set/add/time")
    public ResponseResult addRedisToSetByTime(){
        try {
            return ResponseResult.SUCCESS().setData(testService.addSetRedis());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/set/get")
    public ResponseResult getRedisToSet(){
        try {
            return ResponseResult.SUCCESS().setData(testService.getRedisSet());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/hashmap/add")
    public ResponseResult addStringRedis(){
        try {
            return ResponseResult.SUCCESS().setData(testService.addRedisString());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/hashmap/add/time")
    public ResponseResult addStringRedisByTime(){
        try {
            return ResponseResult.SUCCESS().setData(testService.addRedisStringByTime());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/hashmap/get")
    public ResponseResult getHashMap(){
        try {
            return ResponseResult.SUCCESS().setData(testService.getHashMap());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/string/add")
    public ResponseResult addString(){
        try {
            return ResponseResult.SUCCESS().setData(testService.addString());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/string/get")
    public ResponseResult getString(){
        try {
            return ResponseResult.SUCCESS().setData(testService.getString());
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }
}
