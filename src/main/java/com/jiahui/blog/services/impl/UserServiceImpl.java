package com.jiahui.blog.services.impl;

import com.jiahui.blog.dao.SettingsDao;
import com.jiahui.blog.dao.UserDao;
import com.jiahui.blog.pojo.Settings;
import com.jiahui.blog.pojo.User;
import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.services.UserService;
import com.jiahui.blog.utils.Constants;
import com.jiahui.blog.utils.SnowflakeIdWorker;
import com.jiahui.blog.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SettingsDao settingsDao;

    @Override
    public ResponseResult initManagerAccount(User user, HttpServletRequest request) {
        //检查是否有初始化
        Settings admin_state=settingsDao.findOneByKey(Constants.Settings.MANAGER_ACCOUNT_INIT_STATE);
        if (admin_state!=null){
            return ResponseResult.FAILED("管理员账号已经初始化");
        }
        //TODO:
        //检查数据
        if (TextUtils.isEmpty(user.getUserName())){
            return ResponseResult.FAILED("用户名不能为空");
        }
        if (TextUtils.isEmpty(user.getPassword())){
            return ResponseResult.FAILED("用户密码不能为空");
        }
        if (TextUtils.isEmpty(user.getEmail())){
            return ResponseResult.FAILED("用户邮箱不能为空");
        }
        //补充数据
        user.setId(snowflakeIdWorker.nextId()+"");
        user.setRoles(Constants.User.ROLE_ADMIN);
        user.setAvatar(Constants.User.DEFAULT_AVATAR);
        user.setState(Constants.User.DEFAULT_STATE);
        String localIp=request.getLocalAddr();
        log.info("localIp="+localIp);
        String remoteIp=request.getRemoteAddr();
        log.info("remoteIp="+remoteIp);
        user.setRegIp(request.getLocalAddr());
        user.setLoginIp(request.getRemoteAddr());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        String password=user.getPassword();
        //对原密码进行加密
        String passwordEncode=bCryptPasswordEncoder.encode(password);
        user.setPassword(passwordEncode);
        //保存到数据库中
        userDao.save(user);
        //更新已经添加的标记
        Settings settings=new Settings();
        settings.setId(snowflakeIdWorker.nextId()+"");
        settings.setKey(Constants.Settings.MANAGER_ACCOUNT_INIT_STATE);
        settings.setValue("1");
        settings.setCreateTime(new Date());
        settings.setUpdateTime(new Date());
        settingsDao.save(settings);
        return ResponseResult.SUCCESS("初始化成功");
    }
}
