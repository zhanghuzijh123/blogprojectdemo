package com.jiahui.blog.pojo;
import javax.persistence.*;

@Entity
@Table(name = "tb_settings")
public class Settings {

  	@Id
	private String id;

  	@Column(name = "key" )
	private String key;

  	@Column(name = "value" )
	private String value;

  	@Column(name = "create_time" )
	private java.sql.Timestamp createTime;

  	@Column(name = "update_time" )
	private java.sql.Timestamp updateTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
