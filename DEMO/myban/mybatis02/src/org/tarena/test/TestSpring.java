package org.tarena.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.AdminDao;
import org.tarena.entity.Admin;

public class TestSpring {
	@Test
	public void TestSqlSessionFactory(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		SqlSessionFactory ssf = ac.getBean("ssf",SqlSessionFactory.class);
		SqlSession session = ssf.openSession();
		System.out.println(session);
		
		session.close();
	}
	@Test
	public void testAdminDao(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AdminDao dao = ac.getBean("adminDao",AdminDao.class);
		Admin admin = dao.findByCode("admin");
		if(admin != null){
			System.out.println(admin.getName());			
		}else{
			System.out.println("查无此人");
		}
	}
}
