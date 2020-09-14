package com.jiahui.blog.controller.admin;

import com.jiahui.blog.pojo.Images;
import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/image")
public class ImageApi {

    /**
     * 图片上传
     * @return
     */
    @PostMapping
    public ResponseResult uploadImage(){
        return null;
    }

    /**
     * 删除图片
     * @param imageId
     * @return
     */
    @DeleteMapping("/{imageId}")
    public ResponseResult deleteImage(@PathVariable("imageId") String imageId){
        return null;
    }

    /**
     * 修改图片
     * @param imageId
     * @param images
     * @return
     */
    @PutMapping("/{imageId}")
    public ResponseResult updateImage(@PathVariable("imageId") String imageId, @RequestBody Images images){
        return null;
    }

    /**
     * 获取图片
     * @param imageId
     * @return
     */
    @GetMapping("/{imageId}")
    public ResponseResult getImage(@PathVariable("imageId") String imageId){
        return null;
    }

    /**
     * 获取图片列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listImage(@RequestParam("page") int page,@RequestParam("size") int size){
        return null;
    }
}
