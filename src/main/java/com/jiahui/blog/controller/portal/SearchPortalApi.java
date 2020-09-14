package com.jiahui.blog.controller.portal;

import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal/search")
public class SearchPortalApi {
    /**
     * 文章搜索
     * @param keyword
     * @param page
     * @return
     */
    @GetMapping
    public ResponseResult doSearch(@RequestParam("keyword") String keyword,@RequestParam("page") String page){
        return null;
    }
}
