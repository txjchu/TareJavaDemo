package netctoss.test;

import java.util.List;

import netctoss.dao.CostDAO;
import netctoss.entity.Cost;
import netctoss.service.CostService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase2 {
	@Test
	public void test1() throws Exception{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostDAO dao = 
			ac.getBean("costDAO",CostDAO.class);
		List<Cost> costs = 
			dao.findAll();
		System.out.println(costs);
	}
	
	@Test
	public void test2() throws Exception{
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostService 
		service = ac.getBean("costService",CostService.class);
		List<Cost> costs = 
			service.findAll();
		System.out.println(costs);
	}
}
