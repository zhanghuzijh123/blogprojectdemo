package com.jiahui.blog.controller;

import com.jiahui.blog.req.AppUserInsertOrUpdateReq;
import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.services.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/app-user")
public class AppUserController {
    @Resource
    private AppUserService appUserService;

    @PostMapping("/update")
    public ResponseResult getAppUserMethod(@RequestBody AppUserInsertOrUpdateReq req){
        try {
            return ResponseResult.SUCCESS().setData(appUserService.getAppUserMethod(req));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseResult.FAILED(e.getMessage());
        }
    }
}
