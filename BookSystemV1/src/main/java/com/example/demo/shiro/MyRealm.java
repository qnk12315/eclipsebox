package com.example.demo.shiro;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import antlr.Token;

public class MyRealm extends AuthorizingRealm{

	@Resource
	private UserDao UserDao;
	
	/*
	 * 验证url
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String name = (String)SecurityUtils.getSubject().getPrincipal();
		User user = UserDao.findByName(name);
		//通过用户拿到角色
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<>();
		roles.add("管理员");
		info.addStringPermission("添加用户权限");
		info.setRoles(roles);
		return info;
	}

	/*
	 * 权限认证登录
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name =(String)token.getPrincipal();
		User user = UserDao.findByName(name);
		if (user!=null) {
			AuthenticationInfo authinfo = new SimpleAuthenticationInfo(user.getName(), user.getPwd(),"xxx");
			return authinfo;
		}
		return null;
	}

}
