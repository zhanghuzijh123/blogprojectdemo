package com.jiahui.blog.controller.admin;

import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/web_site_info")
public class WebSiteInfoApi {
    /**
     * 获取网站title
     * @return
     */
    @GetMapping("/title")
    public ResponseResult getWebSiteInfoTitle(){
        return null;
    }

    /**
     * 修改网站标题
     * @param title
     * @return
     */
    @PutMapping("/title")
    public ResponseResult updateWebSiteInfoTitle(@RequestParam("title") String title){
        return null;
    }

    /**
     * 获取seo信息
     * @return
     */
    @GetMapping("/seo")
    public ResponseResult getSeoInfo(){
        return null;
    }

    /**
     * 修改网站的seo信息
     * @param keyword
     * @param descripction
     * @return
     */
    @PutMapping("/seo")
    public ResponseResult putSeoInfo(@RequestParam("keyword") String keyword,@RequestParam("descripction") String descripction){
        return null;
    }

    @GetMapping("/view_count")
    public ResponseResult getWebSiteViewCount(){
        return null;
    }
}
