package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoXmlImpl;
import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private UserDao dao = new UserDaoXmlImpl();
	public void regist(User user) throws UserExistException {
		if(user==null)
			throw new IllegalArgumentException("The param user can not be null");
		User dbUser = dao.findUser(user.getUsername());//�Ȳ�ѯ�û����Ƿ����
		if(dbUser!=null){
			//˵���û����Ѿ���ռ����
			throw new UserExistException("The username \""+user.getUsername()+"\"�Ѿ�������");
		}
		dao.save(user);
	}

	public User login(String username, String password) {
		return dao.findUser(username, password);
	}

}
