package com.jiahui.blog.pojo;

import lombok.Data;

@Data
public class ResponseObject {
    private Integer code;
    private Object data;
    private String msg;
    private String result;
}
