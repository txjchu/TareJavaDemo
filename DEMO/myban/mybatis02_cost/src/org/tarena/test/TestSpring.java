package org.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;

public class TestSpring {
	@Test
	public void testCostDao(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		CostDao dao = ac.getBean("costDao",CostDao.class);
		Cost cost = dao.findById(2);
		if(cost != null){
			System.out.println(cost.getName()+cost.getDescr());
		}else{
			System.out.println("查无此类资费");
		}
	}
	@Test
	public void testFindAll(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostDao costDao = ac.getBean("costDao",CostDao.class);
		List<Cost> list = costDao.findAll();
		for(Cost c : list){
			System.out.println(c.getName()+" "+c.getCost_id());
		}
	}
}
