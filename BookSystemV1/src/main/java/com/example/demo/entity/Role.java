package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
   *   角色类
 * @author qnk12
 *
 */
@Entity
@Table(name="t_a_role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "角色名不能为空")
	@Column(length = 30)
	private String name; // 角色名
	
	
	
	@NotNull(message = "排序号不能为空")
	@Column(length = 10)
	private Integer orderNo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime; // 创建时间
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDateTime; // 修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", orderNo=" + orderNo + ", createDateTime="
				+ createDateTime + ", updateDateTime=" + updateDateTime + "]";
	}
	
	
}
