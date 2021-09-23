package com.jiahui.blog.services.impl;

import com.jiahui.blog.utils.MapUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * MapServiceImpl
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Service
public class MapServiceImpl {

    public void get(){
        RestTemplate restTemplate = new RestTemplate();
        String url = MapUtils.MAP_URL+"?ak="+MapUtils.USER_AK+"&coor="+MapUtils.COOR;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
    }
}
