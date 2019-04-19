package netctoss.test;

import java.util.List;

import netctoss.dao.DAOFactory;
import netctoss.dao.LoginDAO;
import netctoss.entity.Admin;
import netctoss.util.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;

/**
 * 测试LoginDAO中的findByName方法
 * @author Administrator
 *
 */
public class TestAdminDAO {

	@Test
	public void testFindByCode(){
		LoginDAO dao = DAOFactory.getLoginDAO();
		Admin admin = dao.findByCode("caocao");
		HibernateUtil.close();
		System.out.println(admin);
	}
	@Test
	public void testFindAll(){
		LoginDAO dao = DAOFactory.getLoginDAO();
		List<Admin> admins = dao.findAll();
		for(Admin admin : admins){
			System.out.println(admin);
		}
	}
}
