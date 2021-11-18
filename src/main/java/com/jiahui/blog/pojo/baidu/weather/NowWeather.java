package com.jiahui.blog.pojo.baidu.weather;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * NowWeather
 *
 * @author Administrator
 * @date 2021/11/2 0002
 */
@Data
public class NowWeather {
    /**
     * 天气
     */
    private String text;
    /**
     * 温度（℃）
     */
    private Integer temp;
    /**
     * 体感温度(℃)
     */
    private Integer feels_like;
    /**
     * 相对湿度(%)
     */
    private Integer rh;
    /**
     * 风力等级
     */
    private String wind_class;
    /**
     * 风向描述
     */
    private String wind_dir;
    /**
     * 数据更新时间，北京时间
     */
    private String uptime;
}
