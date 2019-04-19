package com.tare.cloudnote.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.cloudnote.dao.UserDAO;
import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.util.NoteUtil;

/**
 * 测试UserDAO
 * @author Administrator
 *
 */
public class TestUserDAO {

	private UserDAO dao;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = ac.getBean(UserDAO.class);
	}
	
	@Test
	public void testFindAll(){
		List<User> users = dao.findAll();
		for(User user : users){
			System.out.println(user);
		}
	}
	@Test
	public void testFindByName(){
		User user = dao.findByName("zhouj");
		System.out.println(user);
	}
	@Test
	public void testSave(){
		User user = new User();
		user.setCn_user_id(NoteUtil.createId());//使用工具类自动生成一个id
		user.setCn_user_name("zhouyu2");
		user.setCn_user_password(NoteUtil.md5("123456"));//使用工具类中的方法将密码进行摘要加密
		user.setCn_user_token("周瑜");
		user.setCn_user_desc("周瑜打黄盖");
		int i = dao.save(user);
		System.out.println("储存了  "+ i +"条记录，存入的User对象为："+ dao.findByName("zhouyu"));
		
	}
}
