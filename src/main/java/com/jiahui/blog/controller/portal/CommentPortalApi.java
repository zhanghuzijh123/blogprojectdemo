package com.jiahui.blog.controller.portal;

import com.jiahui.blog.pojo.Comment;
import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal/comment")
public class CommentPortalApi {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping
    public ResponseResult postComment(@RequestBody Comment comment){
        return null;
    }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public ResponseResult deleteComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 获取评论列表
     * @param categoryId
     * @return
     */
    @GetMapping("/list/{categoryId}")
    public ResponseResult listComments(@PathVariable("categoryId") String categoryId){
        return null;
    }
}
