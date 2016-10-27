package com.itheima.dao;

import com.itheima.domain.User;

//������ҵ���߼���ֻ����CRUD
public interface UserDao {
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	void save(User user);
	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return ��������ڷ���null
	 */
	User findUser(String username);
	/**
	 * �����û����������ѯ�û�
	 * @param username
	 * @param password
	 * @return ��������ڷ���null
	 */
	User findUser(String username,String password);
}
