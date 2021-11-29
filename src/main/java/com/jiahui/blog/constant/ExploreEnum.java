package com.jiahui.blog.constant;

/**
 * ExploreEnum
 *
 * @author Administrator
 * @date 2021/11/3 0003
 */
public enum ExploreEnum {
    VILLAGE(0,"村庄",0,20),
    BARBARIANS(1,"部落",20,35),
    NEIGHBOR(2,"邻邦",35,45),
    LUXURY(3,"奢侈品",45,60),
    CROPPER(4,"农作物",60,85),
    CAMPSITE(5,"营地",85,100);
    private Integer code;
    private String name;
    private Integer min;
    private Integer max;

    ExploreEnum(Integer code, String name, Integer min, Integer max) {
        this.code = code;
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static Integer getExploreCode(Integer code) {
        Integer exploreCode = -1;
        if (code >= ExploreEnum.VILLAGE.min && code < ExploreEnum.VILLAGE.max) {
            exploreCode = ExploreEnum.VILLAGE.code;
        }
        if (code >= ExploreEnum.BARBARIANS.min && code < ExploreEnum.BARBARIANS.max) {
            exploreCode = ExploreEnum.BARBARIANS.code;
        }
        if (code >= ExploreEnum.NEIGHBOR.min && code < ExploreEnum.NEIGHBOR.max) {
            exploreCode = ExploreEnum.NEIGHBOR.code;
        }
        if (code >= ExploreEnum.LUXURY.min && code < ExploreEnum.LUXURY.max) {
            exploreCode = ExploreEnum.LUXURY.code;
        }
        if (code >= ExploreEnum.CROPPER.min && code < ExploreEnum.CROPPER.max) {
            exploreCode = ExploreEnum.CROPPER.code;
        }
        if (code >= ExploreEnum.CAMPSITE.min && code < ExploreEnum.CAMPSITE.max) {
            exploreCode = ExploreEnum.CAMPSITE.code;
        }
        return exploreCode;
    }

    public static Integer getExploreCodeByNew(Integer code){
        int grade = code / 10 + 1;
        if (code == 100){
            grade = code / 10 - 1;
        }
        return grade;
    }
}
