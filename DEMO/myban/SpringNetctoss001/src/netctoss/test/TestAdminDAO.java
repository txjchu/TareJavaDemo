package netctoss.test;

import java.util.List;

import netctoss.dao.AdminDAO;
import netctoss.dao.AdminDAOImpl;
import netctoss.entity.Admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestAdminDAO {

	private AdminDAO dao;
	@Before
	public void testBefore(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = ac.getBean("adminDAOImpl", AdminDAOImpl.class);
	}
	@Test
	public void testFindAll(){
		List<Admin> admins = dao.findAll();
		for(Admin admin : admins){
			System.out.println(admin);
		}
	}
	@Test
	public void testFindByAdminCode(){
		Admin admin = dao.findByCode("caocao");
		System.out.println(admin);
	}
	
}
