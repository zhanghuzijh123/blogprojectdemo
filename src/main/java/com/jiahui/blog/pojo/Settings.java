package com.jiahui.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_settings")
public class Settings implements Serializable,Cloneable {
    /** 设置项ID */
    @Id
    private String id ;
    /** 设置项key */
    private String settingKey ;
    /** 设置项value */
    private String settingValue ;

    /** 设置项ID */
    public String getId(){
        return this.id;
    }
    /** 设置项ID */
    public void setId(String id){
        this.id = id;
    }
    /** 设置项key */
    public String getSettingKey(){
        return this.settingKey;
    }
    /** 设置项key */
    public void setSettingKey(String settingKey){
        this.settingKey = settingKey;
    }
    /** 设置项value */
    public String getSettingValue(){
        return this.settingValue;
    }
    /** 设置项value */
    public void setSettingValue(String settingValue){
        this.settingValue = settingValue;
    }
}
