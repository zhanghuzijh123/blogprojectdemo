package com.jiahui.blog.controller.portal;

import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal/web_site_info")
public class WebSiteInfoPortalApi {
    /**
     * 获取分类
     * @return
     */
    @GetMapping("/categories")
    public ResponseResult getCategories(){
        return null;
    }


    /**
     * 获取网站标题
     * @return
     */
    @GetMapping("/title")
    public ResponseResult getWebSiteTitle(){
        return null;
    }


    /**
     * 获取访问量数据view-count
     * @return
     */
    @GetMapping("/view_count")
    public ResponseResult getWebSiteViewCount(){
        return null;
    }

    /**
     * 获取网站seo信息
     * @return
     */
    @GetMapping("/seo")
    public ResponseResult getWebSiteSeoInfo(){
        return null;
    }

    /**
     * 获取轮播图列表
     * @return
     */
    @GetMapping("/looper")
    public ResponseResult getLoopers(){
        return null;
    }

    /**
     * 获取友情链接列表
     * @return
     */
    @GetMapping("/friend_link")
    public ResponseResult getLinks(){
        return null;
    }
}
