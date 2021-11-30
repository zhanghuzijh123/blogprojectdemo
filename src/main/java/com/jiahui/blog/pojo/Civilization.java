package com.jiahui.blog.pojo;

import lombok.Data;

/**
 * Civilization
 *
 * @author Administrator
 * @date 2021/11/3 0003
 */
@Data
public class Civilization {
    private Integer attack = 20;
    private Integer food = 10;
    private Integer defence = 100;
    private Integer person = 2;
    private Integer luxury = 0;
    private Integer cropper = 0;
    private Integer barbarians = 0;
    private Integer neighbor = 0;
    private Integer campsite = 0;
}
