package com.jiahui.blog.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * StreamBO
 *
 * @author Administrator
 * @date 2021/11/5 0005
 */
@Data
public class StreamBO {
    private Long streamId;
    private String streamName;
    private Date createTime;
    private BigDecimal streamValue;
}
