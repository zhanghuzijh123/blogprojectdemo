package com.jiahui.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_category")
public class Category implements Serializable,Cloneable {
    /** ID */
    @Id
    private String id ;
    /** 分类名称 */
    private String categoryName ;
    /** 分类拼音 */
    private String categoryPy ;
    /** 描述说明 */
    private String description ;
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
    /** 分类名称 */
    public String getCategoryName(){
        return this.categoryName;
    }
    /** 分类名称 */
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    /** 分类拼音 */
    public String getCategoryPy(){
        return this.categoryPy;
    }
    /** 分类拼音 */
    public void setCategoryPy(String categoryPy){
        this.categoryPy = categoryPy;
    }
    /** 描述说明 */
    public String getDescription(){
        return this.description;
    }
    /** 描述说明 */
    public void setDescription(String description){
        this.description = description;
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
