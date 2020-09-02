package com.jiahui.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_looper")
public class Looper implements Serializable,Cloneable {
    /** ID */
    @Id
    private String id ;
    /** 轮播图的Url */
    private String url ;
    /** 图片路径 */
    private String path ;
    /** 标题 */
    private String title ;
    /** 顺序 */
    private Integer order ;

    /** ID */
    public String getId(){
        return this.id;
    }
    /** ID */
    public void setId(String id){
        this.id = id;
    }
    /** 轮播图的Url */
    public String getUrl(){
        return this.url;
    }
    /** 轮播图的Url */
    public void setUrl(String url){
        this.url = url;
    }
    /** 图片路径 */
    public String getPath(){
        return this.path;
    }
    /** 图片路径 */
    public void setPath(String path){
        this.path = path;
    }
    /** 标题 */
    public String getTitle(){
        return this.title;
    }
    /** 标题 */
    public void setTitle(String title){
        this.title = title;
    }
    /** 顺序 */
    public Integer getOrder(){
        return this.order;
    }
    /** 顺序 */
    public void setOrder(Integer order){
        this.order = order;
    }
}
