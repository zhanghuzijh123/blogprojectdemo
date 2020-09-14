package com.jiahui.blog.controller.admin;

import com.jiahui.blog.pojo.FriendLink;
import com.jiahui.blog.pojo.Looper;
import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/friend")
public class FriendLinkApi {

    /**
     * 添加友情链接
     * @param friendLink
     * @return
     */
    @PostMapping
    public ResponseResult addFriendLink(@RequestBody FriendLink friendLink){
        return null;
    }

    /**
     * 删除友情链接
     * @param friendLinkId
     * @return
     */
    @DeleteMapping("/{friendLinkId}")
    public ResponseResult deleteFriendLink(@PathVariable("friendLinkId") String friendLinkId){
        return null;
    }

    /**
     * 修改友情链接
     * @param friendLinkId
     * @param friendLink
     * @return
     */
    @PutMapping("/{friendLinkId}")
    public ResponseResult updateFriendLinkId(@PathVariable("friendLinkId") String friendLinkId, @RequestBody FriendLink friendLink){
        return null;
    }

    /**
     * 获取友情链接
     * @param friendLinkId
     * @return
     */
    @GetMapping("/{friendLinkId}")
    public ResponseResult getFriendLinkId(@PathVariable("friendLinkId") String friendLinkId){
        return null;
    }

    /**
     * 获取友情链接列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listFriendLinkIds(@RequestParam("page") int page,@RequestParam("size") int size){
        return null;
    }
}
