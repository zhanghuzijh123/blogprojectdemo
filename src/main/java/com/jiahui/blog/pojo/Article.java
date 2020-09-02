package com.jiahui.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_article")
public class Article implements Serializable,Cloneable {
    /** ID */
    @Id
    private String id ;
    /** 用户ID */
    private String userId ;
    /** 分类ID */
    private String categoryId ;
    /** 内容 */
    private String content ;
    /** 类型;0表示富文本，1表示markdown */
    private Integer type ;
    /** 状态;0表示已经发布，1表示草稿，2表示等待发布 */
    private Integer status ;
    /** 浏览量 */
    private Integer viewCount ;
    /** 发布时间 */
    private Date publishTime ;
    /** 更新时间 */
    private Date updateTime ;

    /** ID */
    public String getId(){
        return this.id;
    }
    /** ID */
    public void setId(String id){
        this.id = id;
    }
    /** 用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 用户ID */
    public void setUserId(String userId){
        this.userId = userId;
    }
    /** 分类ID */
    public String getCategoryId(){
        return this.categoryId;
    }
    /** 分类ID */
    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
    }
    /** 内容 */
    public String getContent(){
        return this.content;
    }
    /** 内容 */
    public void setContent(String content){
        this.content = content;
    }
    /** 类型;0表示富文本，1表示markdown */
    public Integer getType(){
        return this.type;
    }
    /** 类型;0表示富文本，1表示markdown */
    public void setType(Integer type){
        this.type = type;
    }
    /** 状态;0表示已经发布，1表示草稿，2表示等待发布 */
    public Integer getStatus(){
        return this.status;
    }
    /** 状态;0表示已经发布，1表示草稿，2表示等待发布 */
    public void setStatus(Integer status){
        this.status = status;
    }
    /** 浏览量 */
    public Integer getViewCount(){
        return this.viewCount;
    }
    /** 浏览量 */
    public void setViewCount(Integer viewCount){
        this.viewCount = viewCount;
    }
    /** 发布时间 */
    public Date getPublishTime(){
        return this.publishTime;
    }
    /** 发布时间 */
    public void setPublishTime(Date publishTime){
        this.publishTime = publishTime;
    }
    /** 更新时间 */
    public Date getUpdateTime(){
        return this.updateTime;
    }
    /** 更新时间 */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }
}
