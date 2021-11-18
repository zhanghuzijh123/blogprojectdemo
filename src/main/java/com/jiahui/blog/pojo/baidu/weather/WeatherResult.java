package com.jiahui.blog.pojo.baidu.weather;

import lombok.Data;

import java.util.List;

/**
 * WeatherResult
 *
 * @author Administrator
 * @date 2021/11/2 0002
 */
@Data
public class WeatherResult {
    private WeatherLocation location;
    private NowWeather now;
    private List<Forecasts> forecasts;
}
