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
 * ����UserDAO
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
		user.setCn_user_id(NoteUtil.createId());//ʹ�ù������Զ�����һ��id
		user.setCn_user_name("zhouyu2");
		user.setCn_user_password(NoteUtil.md5("123456"));//ʹ�ù������еķ������������ժҪ����
		user.setCn_user_token("���");
		user.setCn_user_desc("��褴�Ƹ�");
		int i = dao.save(user);
		System.out.println("������  "+ i +"����¼�������User����Ϊ��"+ dao.findByName("zhouyu"));
		
	}
}
