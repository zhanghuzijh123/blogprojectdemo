package com.jiahui.blog.controller.admin;

import com.jiahui.blog.pojo.Categories;
import com.jiahui.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * 管理中心，分类API
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryAdminApi {

    /**
     * 添加管理分类
     * @param categories
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody Categories categories){
        return null;
    }

    /**
     * 删除管理分类
     * @param categoryId
     * @return
     */
    @DeleteMapping("/{categoryId}")
    public ResponseResult deleteCategory(@PathVariable("categoryId") String categoryId){
        return null;
    }

    /**
     * 修改管理分类
     * @param categoryId
     * @param categories
     * @return
     */
    @PutMapping("/{categoryId}")
    public ResponseResult updateCategory(@PathVariable("categoryId") String categoryId,@RequestBody Categories categories){
        return null;
    }

    /**
     * 获取管理分类
     * @param categoryId
     * @return
     */
    @GetMapping("/{categoryId}")
    public ResponseResult getCategory(@PathVariable("categoryId") String categoryId){
        return null;
    }

    /**
     * 获取管理分类列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listCategory(@RequestParam("page") int page,@RequestParam("size") int size){
        return null;
    }
}
