package org.exercise.test;

import org.exercise.service.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("org/exercise/applicationContext.xml");
		DeptService service = ac.getBean("deptService", DeptService.class);
		service.addDept();//������Ӳ��Ų����ķ���
		service.updateDept();//�����޸Ĳ��Ų����ķ���
		service.deleteDept();//����ɾ�����Ų����ķ���
		
		
	}
}
