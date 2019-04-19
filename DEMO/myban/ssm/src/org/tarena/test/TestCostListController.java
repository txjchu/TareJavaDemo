package org.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.controller.CostListController;
import org.tarena.entity.Cost;

public class TestCostListController {
	@Test
	public void test1(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostListController controller = ac.getBean("costListController",CostListController.class);
		List<Cost> list = controller.execute();
		for(Cost c:list){
			System.out.println(c.getCost_id()+" "+c.getName());
		}
	}
}
