package com.jiahui.blog.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyFile {
    /**
    * 文件夹主键id
    */
    private Long fileId;

    /**
    * 父文件夹id
    */
    private String fileParent;

    /**
    * 水库基础表外键
    */
    private Long reservoirId;

    /**
    * 文件名字
    */
    private String fileName;

    /**
    * 文件大小
    */
    private Long filesSize;

    /**
    * 版本
    */
    private Integer version;

    /**
    * 创建人
    */
    private Long createUid;

    /**
    * 修改人
    */
    private Long updateUid;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 删除状态：0-正常；1-删除
    */
    private Integer isDelete;

    /**
    * 一库一策类型：3-水库；6-小水电
    */
    private Integer reservoirType;
}