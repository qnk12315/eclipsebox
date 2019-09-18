package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.config;

public interface ConfigService {
	/*/
	 * 加载项目名称
	 */
	
	public config findById(Integer id);
	
}
