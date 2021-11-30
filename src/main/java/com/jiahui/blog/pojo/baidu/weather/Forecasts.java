package com.jiahui.blog.pojo.baidu.weather;

import lombok.Data;

/**
 * Forecasts
 *
 * @author Administrator
 * @date 2021/11/2 0002
 */
@Data
public class Forecasts {
    /**
     * 白天天气现象
     */
    private String text_day;
    /**
     * 晚上天气现象
     */
    private String text_night;
    /**
     * 最高温度(℃)
     */
    private Integer high;
    /**
     * 最低温度(℃)
     */
    private Integer low;
    /**
     * 白天风力
     */
    private String wc_day;
    /**
     * 晚上风力
     */
    private String wd_day;
    /**
     * 白天风向
     */
    private String wc_night;
    /**
     * 晚上风向
     */
    private String wd_night;
    /**
     * 日期，北京时区
     */
    private String date;
    /**
     * 星期，北京时区
     */
    private String week;
}
