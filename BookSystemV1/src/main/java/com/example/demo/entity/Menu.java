package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *   菜单实体
* @author qnk12
*
*/
@Entity
@Table(name="t_menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 10)
	private Integer pId;  //父级菜单
	
	@Column(length = 50)
	private String name;  //菜单名称
	
	@Column(length = 200)
	private String url;   //菜单地址
	
	@Column(length = 200)
	private Integer state;  // 菜单节点类型      0根节点close,     1叶子节点open
	
	@Column(length = 100)
	private String icon;   //图标
	
	@Column(length = 100)
	private String permission; //对应的shiro权限 user:add permission也可以是中文
	
	@Column(length = 10)
	private Integer type;  //默认0选项卡打开   1新窗口打开  2弹出窗口打开
	
	@Column(length = 50)
	private String divID;  //layUI的菜单ID
	
	@NotNull(message = "排序号不能为空")
	@Column(length = 30)
	private Integer orderNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDivID() {
		return divID;
	}

	public void setDivID(String divID) {
		this.divID = divID;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", pId=" + pId + ", name=" + name + ", url=" + url + ", state=" + state + ", icon="
				+ icon + ", permission=" + permission + ", type=" + type + ", divID=" + divID + ", orderNo=" + orderNo
				+ "]";
	}
	
	
	
}
