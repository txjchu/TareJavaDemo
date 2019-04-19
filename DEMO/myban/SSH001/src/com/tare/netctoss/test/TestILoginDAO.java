package com.tare.netctoss.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.netctoss.dao.ILoginDAO;
import com.tare.netctoss.entity.Admin;

/**
 * ≤‚ ‘ILoginDAO
 * @author Administrator
 *
 */
public class TestILoginDAO {

	private ILoginDAO loginDAO;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		loginDAO = ac.getBean(ILoginDAO.class);
	}
	@Test
	public void testFindAtll(){
		List<Admin> admins = loginDAO.findAll();		
		for(Admin a : admins){
			System.out.println(a);
		}
	}
	
	@Test
	public void testFindByCode(){
		Admin admin = loginDAO.findByCode("caocao");
		System.out.println("FindByCode:"+ admin);
	}
}
