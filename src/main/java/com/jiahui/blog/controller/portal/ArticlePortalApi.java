package com.jiahui.blog.controller.portal;

import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal/article")
public class ArticlePortalApi {
    /**
     * 获取文章列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public ResponseResult listArticle(@PathVariable("page") String page,@PathVariable("size") String size){
        return null;
    }

    /**
     * 根据分类获取文章列表
     * @param categoryId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{categoryId}/{page}/{size}")
    public ResponseResult listArticleByCategoryId(@PathVariable("categoryId") String categoryId,
                                                  @PathVariable("page") String page,
                                                  @PathVariable("size") String size){
        return null;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    public ResponseResult getArticleDetail(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 获取推荐文章
     * @param articleId
     * @return
     */
    @GetMapping("/recommend/{articleId}")
    public ResponseResult getCommendArticle(@PathVariable("articleId") String articleId){
        return null;
    }
}
