package netctoss.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import netctoss.dao.AdminDAO;
import netctoss.entity.Admin;
import netctoss.service.LoginService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestCase {
	@Test
	//测试一下db.properties能否正确读取
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		Properties props = 
			ac.getBean("jdbc",Properties.class);
		System.out.println(props);
	}
	
	@Test
	public void test2() throws SQLException{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		DataSource ds =
			ac.getBean("dataSource",
					DataSource.class);
		//System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void test3() throws Exception{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		AdminDAO dao = 
			ac.getBean("adminDAO",AdminDAO.class);
		Admin admin = 
			dao.findByAdminCode("caocao");
		System.out.println(admin);
	}
	
	@Test
	public void test4() throws Exception{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		LoginService 
		service = ac.getBean("loginService",
				LoginService.class);
		Admin admin = service.login("caocao", 
				"1234");
		System.out.println(admin);
	}
	
	
	
	
	
	
}
