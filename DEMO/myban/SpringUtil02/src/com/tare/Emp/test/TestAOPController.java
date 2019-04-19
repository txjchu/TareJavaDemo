package com.tare.Emp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.tare.Emp.controller.EmpController;
import com.tare.Emp.controller.EmpController2;

/**
 * 测试方面组件切入controller组件中的效果
 * @author Administrator
 *
 */
public class TestAOPController {
	
	private ApplicationContext ac = null;
	EmpController ctl = null;
	EmpController2 ctl2 = null;
	@Before
	public void beforeTest(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctl = ac.getBean(EmpController.class);
		ctl2 = ac.getBean(EmpController2.class);
	}
	@Test
	public void testBeforeAOP(){
		ModelMap model = new ModelMap();
		ctl.loadEmpList(model);
	}
	@Test
	public void testAroundAOP(){
		ModelMap model = new ModelMap();
		ctl2.loadList(model);
	}
}
