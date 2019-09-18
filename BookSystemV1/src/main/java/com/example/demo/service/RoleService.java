package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Role;

public interface RoleService {
	//更新角色资料
	public Integer update(Role role);
	
	/**
	 * @param map
	 * @param page  从0开始 
	 * @param pageSize
	 */
	public List<Role> list(Map<String,Object> map,Integer page,Integer pageSize);
	
	public Long getTotal(Map<String,Object> map);
}
