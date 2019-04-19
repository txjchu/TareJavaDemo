package com.tare.emp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.tare.emp.controller.EmpController;
import com.tare.emp.entity.Emp;
import com.tare.emp.service.EmpService;

/**
 * 测试EmpController控制器
 * @author Administrator
 *
 */
public class TestEmpController {
	/*
	 * beanpostprocessor before instantiation of bean failed
	 * nested 嵌套的		illegalArgument 非法的参数		internal 内部的	advisor 顾问		
	 */

	private EmpController empController = null;
	
	@Before
	public void beforeTest(){		// wildcard 		pattern 图案模式		allowed 允许许可
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		empController = ac.getBean("empController", EmpController.class);	//若引用名和默认的bean名字相同，则getBean()方法中不用再传入bean的名字字符串。
	}
	@Test
	public void testFind(){
		String str = empController.find(new ModelMap());
		System.out.println(str);
	}
	@Test
	public void testAddEmp(){
		Emp emp = new Emp();
		emp.setEname("刘备");
		emp.setJob("皇叔");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empController.addEmp(emp);
        
//        Integer.valueOf("abc");//模拟出异常。	测试事务管理是否添加成功。--!不能在这里添加抛异常，这里出异常是该测试方法抛的异常，不是controller组件中的方法抛异常。
//        empController.addEmp();
		// 插入第二个员工
        Emp e2 = new Emp();
        e2.setEname("关羽");
        e2.setJob("候");
        e2.setSal(1000.0);
        e2.setEmpno(10);
        empController.addEmp(e2);
	}
}
