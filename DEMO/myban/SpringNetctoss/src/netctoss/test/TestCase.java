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

/**
 * ��������Ԫ����
 *
 */
public class TestCase {
	@Test
	//����һ��db.properties�ܷ���ȷ��ȡ
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Properties props = ac.getBean("jdbc",Properties.class);
		System.out.println(props);
	}
	@Test
	//��������DataSource �Ƿ�ɹ�
	public void test2() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = ac.getBean("dataSource",DataSource.class);//----DataSource��B  S �ĸ��࣬(��̬)
//		System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	@Test
	public void test3() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDAO dao = ac.getBean("adminDAO",AdminDAO.class);
		Admin admin = dao.findByAdminCode("caocao");
		System.out.println(admin);
	}
	@Test
	public void test4() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService service = ac.getBean("loginService",LoginService.class);
		Admin admin = service.login("caocao", "123");
		System.out.println(admin);
	}
}
