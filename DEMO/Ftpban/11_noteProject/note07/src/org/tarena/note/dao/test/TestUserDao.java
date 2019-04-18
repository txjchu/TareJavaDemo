package org.tarena.note.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.util.SpringTest;

public class TestUserDao extends SpringTest{
	
	@Test
	public void testSave(){
		User user = new User();
		String id = NoteUtil.createId();
		user.setCn_user_id(id);
		user.setCn_user_name("tarena");
		String md5_pwd = NoteUtil.md5("1234");
		user.setCn_user_password(md5_pwd);
		user.setCn_user_token(null);
		user.setCn_user_desc("tarena");
		UserDao userDao = getContext().getBean(
				"userDao",UserDao.class);
		userDao.save(user);
		//È¡³ö
		User db_user = userDao.findByName(
			user.getCn_user_name());
		//¶ÏÑÔ
		Assert.assertEquals(id, db_user.getCn_user_id());
		Assert.assertEquals("tarena",db_user.getCn_user_name());
		Assert.assertEquals(md5_pwd, db_user.getCn_user_password());
		Assert.assertEquals("tarena", db_user.getCn_user_desc());
		Assert.assertNull(db_user.getCn_user_token());
	}
	
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


