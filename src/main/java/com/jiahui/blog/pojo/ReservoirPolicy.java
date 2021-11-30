package com.jiahui.blog.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 运行管理批复
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservoirPolicy {
    /**
    * 一库一策表主键
    */
    private Long policyId;

    /**
    * 水库基础表外键
    */
    private Long reservoirId;

    /**
    * 类型：1-安全监测 ；2-应急措施 ；3-调度方案
    */
    private Integer policyType;

    /**
    * 时间
    */
    private Date policyTime;

    /**
    * 标题
    */
    private String policyTitle;

    /**
    * 批复部门
    */
    private String policyDept;

    /**
    * 内容
    */
    private String policyContent;

    /**
    * 文件id
    */
    private Long fileId;

    /**
    * 文件大小
    */
    private Long fileSize;

    /**
    * 文件
    */
    private String policyFiles;

    /**
    * 文件名字
    */
    private String fileName;

    /**
    * 一库一策类型：3-水库；6-小水电
    */
    private Integer reservoirType;

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
}