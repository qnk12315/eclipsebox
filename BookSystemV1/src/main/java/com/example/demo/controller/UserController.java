package com.example.demo.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.util.CryptographyUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserDao userDao;
	
	@ResponseBody
	@RequestMapping("/login")
	public JSONObject login(String name,String password) throws Exception{
		
		JSONObject result = new JSONObject();
		//获取subject
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,CryptographyUtil.md5(password, "java"));
		try {
			//执行登陆  shiro的登陆
			subject.login(token);
			//执行登陆  shiro的登陆
			
			result.put("success", true);
			result.put("msg", "登录成功");
			User user = userDao.findByName(name);
			subject.getSession().setAttribute("currentUser", user);
			
		} catch (UnknownAccountException e) {
			result.put("success", false);
			result.put("msg", "用户名不存在");
		}catch(IncorrectCredentialsException e){
			result.put("success", false);
			result.put("msg", "密码错误");
		}
		return result;
	}
	
}
