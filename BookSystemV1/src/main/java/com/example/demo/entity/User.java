package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Message;

/**
 * 后台用户
 * 
 * @author qnk12
 *
 */
@Entity
@Table(name="t_a_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@NotNull(message = "用户名不能为空")
	@Column(length = 30)
	private String name; // 用户名
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role; // 角色
	@Column(length = 200)
	private String pwd;
	@NotNull(message = "真实姓名不能为空")
	@Column(length = 200)
	private String trueName;

	@Column(length = 200)
	private String remake;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
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
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", pwd=" + pwd + ", trueName=" + trueName
				+ ", remake=" + remake + ", orderNo=" + orderNo + ", createDateTime=" + createDateTime
				+ ", updateDateTime=" + updateDateTime + "]";
	}

}
