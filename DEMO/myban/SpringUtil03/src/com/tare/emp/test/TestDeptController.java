package com.tare.emp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.tare.emp.controller.DeptController;

/**
 * ²âÊÔDeptController×é¼þ
 * @author Administrator
 *
 */
public class TestDeptController {

	private DeptController deptController = null;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		deptController = ac.getBean(DeptController.class);
	}
	@Test
	public void testLoad(){
		String str = deptController.loadDept(new ModelMap());
		System.out.println(str);
	}
	@Test
	public void testAddDept() throws ClassNotFoundException{
		deptController.addDept();
	}
}
