package com.example.demo.service.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ConfigDao;
import com.example.demo.entity.config;
import com.example.demo.service.ConfigService;
@Service("configService")
public class ConfigServiceImpl implements ConfigService{

	@Resource
	private ConfigDao configDao;
	@Override
	public config findById(Integer id) {
		// TODO Auto-generated method stub
		return configDao.findId(1);
	}
	
}
