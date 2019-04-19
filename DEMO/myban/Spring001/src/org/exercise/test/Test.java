package org.exercise.test;

import org.exercise.service.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("org/exercise/applicationContext.xml");
		DeptService service = ac.getBean("deptService", DeptService.class);
		service.addDept();//调用添加部门操作的方法
		service.updateDept();//调用修改部门操作的方法
		service.deleteDept();//调用删除部门操作的方法
		
		
	}
}
