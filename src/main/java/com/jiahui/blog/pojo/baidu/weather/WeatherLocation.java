package com.jiahui.blog.pojo.baidu.weather;

import lombok.Data;

/**
 * WeatherLocation
 * 百度天气返回接口location
 * @author Administrator
 * @date 2021/11/2 0002
 */
@Data
public class WeatherLocation {
    /**
     * 国家名称
     */
    private String country;
    /**
     * 省份名称
     */
    private String province;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 区县名称
     */
    private String name;
    /**
     * 区划id
     */
    private String id;
}
