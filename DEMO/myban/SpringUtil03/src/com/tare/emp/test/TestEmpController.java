package com.tare.emp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.tare.emp.controller.EmpController;

/**
 * 测试Emp控制器+业务组件
 * @author Administrator
 *
 */
public class TestEmpController {

	private EmpController empController = null;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		empController = ac.getBean(EmpController.class);
	}
	
	@Test
	public void testLoadEmpList(){//用于测试AOP方面组件的切入，各种通知类型
		System.out.println(empController);
		String str = empController.loadEmpList(new ModelMap());
		System.out.println(str);
	}
	@Test
	public void testSaveEmp(){//测试事务控制
		try {
			empController.saveEmp();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getClass().getName());//测试非RuntimeException异常，是否会回滚。
			e.printStackTrace();
		}
	}
}
