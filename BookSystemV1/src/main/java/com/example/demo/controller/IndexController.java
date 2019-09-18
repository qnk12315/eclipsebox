package com.example.demo.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.util.BrowserUtil;



@Controller

public class IndexController {
	@Autowired ServletContext servletContext;
	
	/**
	 * 首页
	 */
	@RequestMapping("/")
	public String index_1(HttpServletResponse res,HttpServletRequest rqs)throws Exception {
		
		return "redirect:/login";//"pc/login/login";
				//"redirect:/login";
	}
	/**
	 * 首页
	 * @param res
	 * @param rqs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public String index(HttpServletResponse res,HttpServletRequest rqs)throws Exception {
		
		return "redirect:/login";
	}
	
	/*
	 * 后台用户
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		//判断AppleWebKit 和  Firefox    
		String UserAgent = req.getHeader("User-Agent");
		//判断AppleWebKit 和  Firefox    
		if(BrowserUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/common/s_mode");
		}
			return mav;
	}
	
	@RequestMapping("/admin/main")
	public ModelAndView admin_main(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		//判断AppleWebKit 和  Firefox    
		String UserAgent = req.getHeader("User-Agent");
		//判断AppleWebKit 和  Firefox    
		if(BrowserUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/admin/main");
		}else{
			mav.setViewName("/common/s_mode");
		}
			
			return mav;
	}
}
