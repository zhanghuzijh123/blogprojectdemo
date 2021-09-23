package com.jiahui.blog.pojo.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * PointBO
 *
 * @author Administrator
 * @date 2021/9/17 0017
 */
@Data
public class PointBO {
    /**
     * 横坐标
     */
    private BigDecimal x;
    /**
     * 纵坐标
     */
    private BigDecimal y;
}
