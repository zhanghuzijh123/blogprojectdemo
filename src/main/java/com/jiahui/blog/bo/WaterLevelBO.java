package com.jiahui.blog.bo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WaterLevelBO {
    private BigDecimal realTimeWaterLevel;
    private BigDecimal typhoonLevel;
    private BigDecimal rainyLevel;
    private Long testId;
}
