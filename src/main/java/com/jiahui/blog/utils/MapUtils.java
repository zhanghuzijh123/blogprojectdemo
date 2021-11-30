package com.jiahui.blog.utils;

import com.alibaba.fastjson.JSONObject;
import com.jiahui.blog.pojo.IPInfor;
import com.jiahui.blog.pojo.baidu.weather.Forecasts;
import com.jiahui.blog.pojo.baidu.weather.NowWeather;
import com.jiahui.blog.pojo.baidu.weather.WeatherLocation;
import com.jiahui.blog.pojo.baidu.weather.WeatherResult;
import com.jiahui.blog.pojo.response.BaiDuResponseResult;
import com.jiahui.blog.services.impl.MapServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.invoke.empty.Empty;

import javax.annotation.Resource;
import java.util.List;

/**
 * MapUtils
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Slf4j
public class MapUtils {
    public static final String MAP_URL = "https://api.map.baidu.com/location/ip";
    public static final String WEATHER_URL = "https://api.map.baidu.com/weather/v1/";
    public static final String USER_AK = "S5SXUExPwI3HdaeO722o5BT8sTrsIcGR";
    public static final String USER_SERVER_AK = "dFIgC1Wk7tdNQsQtswZGfwHXusMXph8i";
    /**
     * 百度经纬度坐标
     */
    public static final String COOR = "bd09ll";

    /**
     * 获取当前定位信息
     * @return
     */
    public static IPInfor mapTest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MapUtils.MAP_URL + "?ak=" + MapUtils.USER_AK + "&coor=" + MapUtils.COOR;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        IPInfor ipInfor = JSONObject.parseObject(forEntity.getBody(), IPInfor.class);
        return ipInfor;
    }

    /**
     * 获取所在区划编码下的实时天气及未来天气情况
     * @param areaCode
     */
    public static Object getWeatherByAreaCode(String areaCode) {
        RestTemplate restTemplate = new RestTemplate();
        String weatherUrl = WEATHER_URL + "?district_id=" + areaCode + "&data_type=all&ak=" + USER_SERVER_AK;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(weatherUrl, String.class);
        BaiDuResponseResult baiDuResponseResult
                = JSONObject.parseObject(forEntity.getBody(), BaiDuResponseResult.class);
        Object result = baiDuResponseResult.getResult();
        return result;
    }
}
