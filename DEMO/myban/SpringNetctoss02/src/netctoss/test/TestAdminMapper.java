package netctoss.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import netctoss.dao.AdminMapper;
import netctoss.entity.Admin;
import netctoss.service.LoginService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��������Ԫ����
 *
 */
public class TestAdminMapper {
	
	AdminMapper mapper ;
	@Before
	public void testBefore(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = ac.getBean("adminMapper", AdminMapper.class);
	}
	@Test
	public void testFindAll(){
		List<Admin> admins = mapper.findAll();
		for(Admin admin : admins){
			System.out.println(admin);
		}
	}
	@Test
	public void testFindByAdminCode(){		// nested Ƕ�׵���Ƕ��	specified �涨����ϸ˵����ָ���� 	nor Ҳ��Ҳû�� 		neither �Ȳ�..Ҳ��..���߶���
		Admin admin = mapper.findByAdminCode("caocao");
		System.out.println(admin);
	}
	
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
	public void test4() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService service = ac.getBean("loginService",LoginService.class);
		Admin admin = service.login("caocao", "123");
		System.out.println(admin);
	}
}
