package com.jiahui.blog.pojo.bo;

import lombok.Data;

/**
 * AddressDetailBO
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Data
public class AddressContentBO {
    /**
     * 本地ip地址
     */
    private String address;
    /**
     * 当地地址详情
     */
    private AddressDetailBO addressDetail;
    /**
     * 本地坐标ip
     */
    private PointBO point;
}
