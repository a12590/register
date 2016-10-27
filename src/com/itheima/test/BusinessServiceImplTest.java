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
//	@BeforeClass//所有测试方法执行前执行，执行一次
//	public static void m1(){
//		System.out.println("Before");
//		s = new BusinessServiceImpl();
//	}
//	@AfterClass //所有测试方法执行后执行，执行一次
//	public static void m2(){
//		System.out.println("After");
//		s = null;
//	}
//	@Before //执行测试方法前，会先执行
//	public void m1(){
//		System.out.println("Before");
//		s = new BusinessServiceImpl();
//	}
//	@After //测试方法执行后
//	public void m2(){
//		System.out.println("After");
//		s = null;
//	}
	//测试方法：
		//1、带有@Test注解
		//2、方法是public的
		//3、方法必须没有返回值
		//4、方法没有任何的参数
	@Test
	public void testRegist() throws UserExistException {
		User user = new User();
		user.setUsername("djx1");
		user.setPassword("123");
		user.setEmail("zxn@itheima.com");
		user.setBirthday(new Date());
		s.regist(user);
	}
	//测试异常的发生
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
