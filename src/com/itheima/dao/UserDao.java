package com.itheima.dao;

import com.itheima.domain.User;

//不负责业务逻辑，只负责CRUD
public interface UserDao {
	/**
	 * 保存用户信息
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return 如果不存在返回null
	 */
	User findUser(String username);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return 如果不存在返回null
	 */
	User findUser(String username,String password);
}
