package com.tare.emp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.tare.emp.controller.EmpController;

/**
 * ����Emp������+ҵ�����
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
	public void testLoadEmpList(){//���ڲ���AOP������������룬����֪ͨ����
		System.out.println(empController);
		String str = empController.loadEmpList(new ModelMap());
		System.out.println(str);
	}
	@Test
	public void testSaveEmp(){//�����������
		try {
			empController.saveEmp();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getClass().getName());//���Է�RuntimeException�쳣���Ƿ��ع���
			e.printStackTrace();
		}
	}
}
