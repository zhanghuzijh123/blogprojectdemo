package com.jiahui.blog.utils;

import com.alibaba.nacos.client.identify.STSConfig;
import com.jiahui.blog.services.impl.MapServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * MapUtils
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Slf4j
public class MapUtils {
    @Resource
    private MapServiceImpl mapService;
    public static final String MAP_URL = "https://api.map.baidu.com/location/ip";
    public static final String USER_AK = "S5SXUExPwI3HdaeO722o5BT8sTrsIcGR";
    public static final String COOR = "bd09ll";

    public void getIPPosition(){
        try {
        }catch (Exception e){
            log.error("-----------------------普通定位出错！"+e);
        }
    }
}
