package com.jiahui.blog.pojo.bo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.lang.ref.PhantomReference;

/**
 * AddressDetailBO
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Data
public class AddressDetailBO {
    /**
     * 城市名
     */
    private String city;
    /**
     * 百度城市编码
     */
    private Integer cityCode;
    /**
     * 省份
     */
    private String province;
}
