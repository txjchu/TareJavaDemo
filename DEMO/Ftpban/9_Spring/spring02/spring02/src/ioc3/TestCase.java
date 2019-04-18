package ioc3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc3/applicationContext.xml");
		Student stu = 
			ac.getBean("stu",Student.class);
		Student stu2 = 
			ac.getBean("stu",Student.class);
		System.out.println(stu == stu2);
	}
	
	@Test
	public void test2(){
		//Æô¶¯ÈÝÆ÷
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc3/applicationContext.xml");
		Student stu = ac.getBean("stu",
				Student.class);
		stu.service();
		//¹Ø±ÕÈÝÆ÷
		ac.close();
	}
	
	@Test
	public void test3(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc3/applicationContext.xml");
//		Programmer pg = 
//			ac.getBean("programmer",Programmer.class);
//		System.out.println(pg);
//		Enginner eg = ac.getBean("enginner",
//				Enginner.class);
//		System.out.println(eg);
		Manager mg = ac.getBean("manager",
				Manager.class);
		System.out.println(mg);
		
	}
}
