package com.jiahui.blog.bo;

import lombok.Data;

import java.util.Date;

@Data
public class DateTimeDefaultBO {
    /**
     * 起始时间
     */
    private Date beginTime;
    /**
     * 截止时间
     */
    private Date endTime;
}
