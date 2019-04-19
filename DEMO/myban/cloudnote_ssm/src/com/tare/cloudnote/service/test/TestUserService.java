package com.tare.cloudnote.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.cloudnote.service.UserService;
import com.tare.cloudnote.service.UserServiceImpl;
import com.tare.cloudnote.util.NoteResult;

/**
 * 测试类：测试UserService中的业务方法
 * @author Administrator
 *
 */
public class TestUserService {

	private UserService service;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ac.getBean(UserServiceImpl.class);
	}
	
	@Test
	public void testCheckLogin(){
		NoteResult result = service.checkLogin("zhouyu", "123456");
		System.out.println(result);
	}
}
