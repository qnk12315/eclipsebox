package com.example.demo.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import javassist.expr.NewArray;
/*
 * 密码加密
 */
public class CryptographyUtil {

	public static void main(String[] args) {
		System.out.println(new Md5Hash("123","java"));

	}
	
	public static String md5(String pwd,String salt) {
		return new Md5Hash(pwd,salt).toString();
	}

}
