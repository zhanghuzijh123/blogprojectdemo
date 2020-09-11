package com.jiahui.blog.controller.user;

import com.jiahui.blog.pojo.User;
import com.jiahui.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {

    /**
     * 初始化管理员账号
     * @param user
     * @return
     */
    @PostMapping("/admin_account")
    public ResponseResult initManagerAccount(@RequestBody User user){
        log.info("username="+user.getUserName());
        log.info("password="+user.getPassword());
        log.info("email="+user.getEmail());
        return ResponseResult.SUCCESS();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping
    public ResponseResult register(@RequestBody User user){
        return null;
    }

    /**
     * 登录账号
     * @param captcha
     * @param user
     * @return
     */
    @PostMapping("/{captcha}")
    public ResponseResult login(@PathVariable String captcha,@RequestBody User user){
        return null;
    }

    /**
     * 获取图灵验证码
     * @return
     */
    @GetMapping("/captcha")
    public ResponseResult getCaptcha(){
        return null;
    }

    /**
     * 发送邮件email
     * @param emailAddress
     * @return
     */
    @GetMapping("/verify_code")
    public ResponseResult sendVerifyCode(@RequestParam String emailAddress){
        log.info("email="+emailAddress);
        return null;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PutMapping("/password")
    public ResponseResult updatePassword(@RequestBody User user){
        return null;
    }

    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    @GetMapping("/{userid}")
    public ResponseResult getUserInfo(@PathVariable String userid){
        return null;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping
    public ResponseResult updateUserInfo(@RequestBody User user){
        return null;
    }
}
