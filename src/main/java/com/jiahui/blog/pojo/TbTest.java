package com.jiahui.blog.pojo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTest {
    private Long testId;

    private String testName;

    private BigDecimal testValue;

    private Long createUid;

    private Date createTime;

    private Long updateUid;

    private Date updateTime;

    private Integer isDelete;
}