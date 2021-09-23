package com.jiahui.blog.pojo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AppUser
 *
 * @author Administrator
 * @date 2021/9/13 0013
 */

/**
 * app测试用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private Long id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别（0:男；1：女）
     */
    private Integer gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    private Date createTime;

    private Date updateTime;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private Integer isDelete;

    private BigDecimal userValue;
}