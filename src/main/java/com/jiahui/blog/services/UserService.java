package com.jiahui.blog.services;

import com.jiahui.blog.pojo.User;
import com.jiahui.blog.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ResponseResult initManagerAccount(User user, HttpServletRequest request);
}
