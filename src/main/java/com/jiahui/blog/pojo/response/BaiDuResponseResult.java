package com.jiahui.blog.pojo.response;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * BaiDuResponseResult
 *
 * @author Administrator
 * @date 2021/11/2 0002
 */
@Data
public class BaiDuResponseResult<T> {
    private Integer status;
    private String message;
    private T result;
}
