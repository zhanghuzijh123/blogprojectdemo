package com.jiahui.blog.controller;

import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.services.TbTestService;
import com.jiahui.blog.services.impl.TbTestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class ApiTestController {
    @Resource
    private TbTestService tbTestService;
    @Resource
    private TbTestServiceImpl tbTestServiceImpl;

    @GetMapping("/calendar")
    public ResponseResult testCalendarMethod(){
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.testCalendar());
        }catch (Exception e){
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/object")
    public ResponseResult testJsonObject(){
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.testInputStreamToJsonObject());
        }catch (Exception e){
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/redis/test")
    public ResponseResult testRedis(){
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.testRedis());
        }catch (Exception e){
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/redisTemplate/test")
    public ResponseResult testRedisTemplate(){
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.testRedisTemplateSaveString());
        }catch (Exception e){
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/redisTemplate/getString")
    public ResponseResult getRedisTemplateStringValue() {
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.getRedisTemplateStringValue());
        } catch (Exception e) {
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResponseResult test(){
        try {
            return ResponseResult.SUCCESS().setData(tbTestService.isEmptyTest());
        }catch (Exception e){
            log.error("error");
            return ResponseResult.FAILED(e.getMessage());
        }
    }

    @GetMapping("/restTemplate")
    public ResponseResult apiToRestTemplate(@RequestParam("tid") Long tid){
        try {
            return ResponseResult.SUCCESS().setData(tbTestServiceImpl.testRestTemplate(tid));
        }catch (Exception e){
            return ResponseResult.FAILED(e.getMessage());
        }
    }


}
