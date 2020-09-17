package com.jiahui.blog.pojo;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_labels")
public class Labels {

  	@Id
	private String id;

  	@Column(name = "name" )
	private String name;

  	@Column(name = "count" )
	private long count;

  	@Column(name = "create_time" )
	private Date createTime;

  	@Column(name = "update_time" )
	private Date updateTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
