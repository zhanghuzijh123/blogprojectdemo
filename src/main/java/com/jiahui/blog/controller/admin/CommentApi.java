package com.jiahui.blog.controller.admin;

import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/comment")
public class CommentApi {
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
     * 获取评论详情
     * @param commentId
     * @return
     */
    @GetMapping("/{commentId}")
    public ResponseResult getComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 获取评论列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listComment(@RequestParam("page") int page,@RequestParam("size") int size){
        return null;
    }

    /**
     * 置顶评论
     * @param commentId
     * @return
     */
    @PutMapping("/top/{commentId}")
    public ResponseResult topComment(@PathVariable("commentId") String commentId){
        return null;
    }
}
