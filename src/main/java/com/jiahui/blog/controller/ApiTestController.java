package com.jiahui.blog.controller;

import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.services.TbTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.swing.*;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class ApiTestController {
    @Resource
    private TbTestService tbTestService;

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
}
