package com.jeeplus.modules.usertest.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.jeeplus.common.utils.SpringContextHolder;
import com.jeeplus.modules.usertest.dao.UserTestDao;
import com.jeeplus.modules.usertest.entity.UserTest;

/**
 * 测试获取ApplicationContext的getBean()方法
 * @author Administrator
 *
 */
public class TestClass {
	
	/**
	 * 
	 */
	@Test
	public void testGetBean(){
		ApplicationContext ac = SpringContextHolder.getApplicationContext();
		System.out.println("ac:"+ ac);
		UserTest us = new UserTest();
		us.setName("张三");
//		UserTest us1 = ac.getBean(UserTestDao.class).getUserTestByName(us);
//		System.out.println("us1:"+ us1.getName());
		
	}
	
	@Test
	public void test1(){
		UserTest ut = new UserTest();
		ut.setName("李四");
		System.out.println("ut:"+ ut.getName());
	}

}
