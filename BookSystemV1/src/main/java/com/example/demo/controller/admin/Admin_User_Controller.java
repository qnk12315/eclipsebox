package com.example.demo.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.CryptographyUtil;
import com.example.demo.util.StringUtil;

import antlr.StringUtils;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/user")
public class Admin_User_Controller {
	@Resource
	private UserDao userDao;
	
	@Resource
	private UserService userService;
	
	/*
	 * /admin/user/add
	 * 添加用户
	 * 
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JSONObject add(@Valid User user,BindingResult bindingResult,HttpServletRequest rqs,HttpServletResponse rps)throws Exception {
		JSONObject result = new JSONObject();
		
		if (bindingResult.hasErrors()) {
			result.put("success", false);
			result.put("msg", bindingResult.getFieldError().getDefaultMessage());
		}else {
			user.setCreateDateTime(new Date());
			user.setPwd(CryptographyUtil.md5(user.getName(), "java"));
			userDao.save(user);
			result.put("success", true);
			result.put("msg", "添加用户成功");
		}
		return result;
	}
	
	/*
	 * /admin/user/update
	 * 修改资料
	 * 
	 */
	@ResponseBody
	@RequestMapping("/update")
	public JSONObject update(@Valid User user,BindingResult bindingResult,HttpServletRequest rqs,HttpServletResponse rps)throws Exception {
		JSONObject result = new JSONObject();
		
		if (bindingResult.hasErrors()) {
			result.put("success", false);
			result.put("msg", bindingResult.getFieldError().getDefaultMessage());
		}else {
			user.setUpdateDateTime(new Date());
			userService.update(user);
			result.put("success", true);
			result.put("msg", "修改成功");
		}
		return result;
	}
	
	/**
	 * /admin/user/set_new_pwd
	 */
	@ResponseBody
	@RequestMapping("/set_new_pwd")
	public JSONObject set_new_pwd( User user,BindingResult bindingResult,HttpServletRequest rqs)throws Exception {
		JSONObject result = new JSONObject();
		user.setUpdateDateTime(new Date());
		if (StringUtil.isNotEmpty(user.getPwd())) {
			user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));
		}
			userService.update(user);
			result.put("success", true);
			result.put("msg", "修改成功");
		
		return result;
	}
	
	/**
	 * /admin/user/list
	 * @param page    默认1
	 * @param limit   数据多少
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit, 
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<User> userList = userService.list(map, page-1, page);
		long total = userService.getTotal(map);
		map.put("data", userList);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		
		return map;
	}
	
	/**
	 * /admin/user/delete
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public JSONObject delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();

		for (int i = 0; i < idsStr.length; i++) {
			userDao.deleteById(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		return result;
	}
	
}
