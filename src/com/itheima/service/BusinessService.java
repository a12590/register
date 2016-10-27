package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;

//根据需求来定
//接口：把注释写的没有歧义
public interface BusinessService {
	/**
	 * 用户注册
	 * @param user 注册信息
	 * @throws UserExistException 如果注册用户名已经存在了，抛出此异常
	 */
	void regist(User user) throws UserExistException;
	/**
	 * 完成用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果用户名或密码错误，要返回null
	 */
	User login(String username,String password);
}
