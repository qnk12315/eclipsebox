package com.example.demo.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import com.example.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	/**
	 * @param curr  当前更新的数据
	 * @param origin   源数据  以前的数据
	 * @return  curr
	 */
	public User repalce(User curr,User origin){
		
		if(curr.getName()==null){
			curr.setName(origin.getName());
		}
		if(curr.getPwd()==null){
			curr.setPwd(origin.getPwd());
		}
		if(curr.getTrueName()==null){
			curr.setTrueName(origin.getTrueName());
		}
		if(curr.getRemake()==null){
			curr.setRemake(origin.getRemake());
		}
		
		if(curr.getOrderNo()==null){
			curr.setOrderNo(origin.getOrderNo());
		}
		if(curr.getCreateDateTime()==null){
			curr.setCreateDateTime(origin.getCreateDateTime());
		}
		if(curr.getUpdateDateTime()==null){
			curr.setUpdateDateTime(origin.getUpdateDateTime());
		}
		if(curr.getRole()==null){
			curr.setRole(origin.getRole());
		}
		
		return curr;
	}
	@Override
	public Integer update(User user) {
		User origin = userDao.findId(user.getId());
		user=repalce(user, origin);
		userDao.save(user);
		return 1;
	}
	@Override
	public List<User> list(Map<String, Object> map, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
