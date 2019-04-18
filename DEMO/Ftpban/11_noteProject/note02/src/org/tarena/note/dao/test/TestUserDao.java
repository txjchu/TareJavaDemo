package org.tarena.note.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;

public class TestUserDao {
	
	@Test
	public void test1(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		UserDao userDao = 
			ac.getBean("userDao",UserDao.class);
		User user = userDao.findByName("demo");
//		System.out.println(user.getCn_user_password());
		Assert.assertNotNull(user);
	}
	
	@Test
	public void test2(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		UserDao userDao = 
			ac.getBean("userDao",UserDao.class);
		User user = userDao.findByName("scott");
//		System.out.println(user.getCn_user_password());
		Assert.assertNull(user);
	}
	
}


