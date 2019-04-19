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
 * ����EmpController������
 * @author Administrator
 *
 */
public class TestEmpController {
	/*
	 * beanpostprocessor before instantiation of bean failed
	 * nested Ƕ�׵�		illegalArgument �Ƿ��Ĳ���		internal �ڲ���	advisor ����		
	 */

	private EmpController empController = null;
	
	@Before
	public void beforeTest(){		// wildcard 		pattern ͼ��ģʽ		allowed �������
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		empController = ac.getBean("empController", EmpController.class);	//����������Ĭ�ϵ�bean������ͬ����getBean()�����в����ٴ���bean�������ַ�����
	}
	@Test
	public void testFind(){
		String str = empController.find(new ModelMap());
		System.out.println(str);
	}
	@Test
	public void testAddEmp(){
		Emp emp = new Emp();
		emp.setEname("����");
		emp.setJob("����");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empController.addEmp(emp);
        
//        Integer.valueOf("abc");//ģ����쳣��	������������Ƿ���ӳɹ���--!����������������쳣��������쳣�Ǹò��Է����׵��쳣������controller����еķ������쳣��
//        empController.addEmp();
		// ����ڶ���Ա��
        Emp e2 = new Emp();
        e2.setEname("����");
        e2.setJob("��");
        e2.setSal(1000.0);
        e2.setEmpno(10);
        empController.addEmp(e2);
	}
}
