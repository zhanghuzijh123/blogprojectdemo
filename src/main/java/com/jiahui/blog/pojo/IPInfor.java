package com.jiahui.blog.pojo;

import com.jiahui.blog.pojo.bo.AddressContentBO;
import lombok.Data;

/**
 * IPInfor
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Data
public class IPInfor {
    /**
     * 地址
     */
    private String address;
    /**
     * 状态
     */
    private Integer status;
    /**
     * ip内容
     */
    private AddressContentBO content;
}
