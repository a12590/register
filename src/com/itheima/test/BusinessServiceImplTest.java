package com.itheima.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;

public class BusinessServiceImplTest {
	private BusinessService s = new BusinessServiceImpl();
//	private static BusinessService s;
//	
//	@BeforeClass//���в��Է���ִ��ǰִ�У�ִ��һ��
//	public static void m1(){
//		System.out.println("Before");
//		s = new BusinessServiceImpl();
//	}
//	@AfterClass //���в��Է���ִ�к�ִ�У�ִ��һ��
//	public static void m2(){
//		System.out.println("After");
//		s = null;
//	}
//	@Before //ִ�в��Է���ǰ������ִ��
//	public void m1(){
//		System.out.println("Before");
//		s = new BusinessServiceImpl();
//	}
//	@After //���Է���ִ�к�
//	public void m2(){
//		System.out.println("After");
//		s = null;
//	}
	//���Է�����
		//1������@Testע��
		//2��������public��
		//3����������û�з���ֵ
		//4������û���κεĲ���
	@Test
	public void testRegist() throws UserExistException {
		User user = new User();
		user.setUsername("djx1");
		user.setPassword("123");
		user.setEmail("zxn@itheima.com");
		user.setBirthday(new Date());
		s.regist(user);
	}
	//�����쳣�ķ���
	@Test(expected=com.itheima.exception.UserExistException.class)
	public void testRegist1() throws UserExistException {
		User user = new User();
		user.setUsername("djx1");
		user.setPassword("123");
		user.setEmail("zxn@itheima.com");
		user.setBirthday(new Date());
		s.regist(user);
	}
	@Test
	public void testLogin() {
		User user = s.login("zxn", "123");
		assertNotNull(user);
		user = s.login("zxn", "1234");
		assertNull(user);
	}

}
