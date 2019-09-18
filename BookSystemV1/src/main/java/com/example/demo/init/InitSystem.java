package com.example.demo.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.example.demo.entity.config;
import com.example.demo.service.ConfigService;

/**
 * 初始化项目名称
 * @author qnk12
 *
 */
@Component
public class InitSystem implements ServletContextListener,ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
	
	@Autowired
    private ConfigService configService;
	
	/*
	 * 加载数据到application中
	 */
	public void loadData(ServletContext application) {
		config config = configService.findById(1);
		application.setAttribute("config", config);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		loadData(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
