package com.jiahui.blog.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiahui.blog.exception.DefaultException;
import com.jiahui.blog.pojo.baidu.weather.Forecasts;
import com.jiahui.blog.pojo.baidu.weather.NowWeather;
import com.jiahui.blog.pojo.baidu.weather.WeatherLocation;
import com.jiahui.blog.pojo.baidu.weather.WeatherResult;
import com.jiahui.blog.utils.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * MapServiceImpl
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Slf4j
@Service
public class MapServiceImpl {

    public void get(){
        RestTemplate restTemplate = new RestTemplate();
        String url = MapUtils.MAP_URL+"?ak="+MapUtils.USER_AK+"&coor="+MapUtils.COOR;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
    }

    /**
     * 获取指定区划的天气情况
     * @param areaCode
     * @return
     */
    public WeatherResult getBaiDuWeather(String areaCode) {
        Object weatherByAreaCode = MapUtils.getWeatherByAreaCode(areaCode);
        if (weatherByAreaCode != null) {
            System.out.println("------------------");
            String str = JSONObject.toJSONString(weatherByAreaCode);
            WeatherResult weatherResult = JSONObject.parseObject(str, WeatherResult.class);
            List<Forecasts> forecasts = weatherResult.getForecasts();
            System.out.println("forecasts: ---------------");
            WeatherLocation location = weatherResult.getLocation();
            System.out.println("location: ---------------");
            NowWeather now = weatherResult.getNow();
            System.out.println("now: ---------------");
            return weatherResult;
        }else {
            throw new DefaultException("返回值有误!");
        }
    }
}
