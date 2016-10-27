package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;

//������������
//�ӿڣ���ע��д��û������
public interface BusinessService {
	/**
	 * �û�ע��
	 * @param user ע����Ϣ
	 * @throws UserExistException ���ע���û����Ѿ������ˣ��׳����쳣
	 */
	void regist(User user) throws UserExistException;
	/**
	 * ����û���¼
	 * @param username �û���
	 * @param password ����
	 * @return ����û������������Ҫ����null
	 */
	User login(String username,String password);
}
