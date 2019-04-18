package org.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;

public class TestCost {
	@Test
	public void testFindAll(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		CostDao costDao = 
			ac.getBean("costDao",CostDao.class);
		List<Cost> list = costDao.findAll();
		for(Cost c : list){
			System.out.println(
				c.getCost_id()+" "+c.getName());
		}
	}
}




