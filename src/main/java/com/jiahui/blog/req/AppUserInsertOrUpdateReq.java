package com.jiahui.blog.req;

import lombok.Data;

import java.util.List;

@Data
public class AppUserInsertOrUpdateReq {
    private List<Long> ids;
}
