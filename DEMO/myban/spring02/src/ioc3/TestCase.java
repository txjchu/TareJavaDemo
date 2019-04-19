package ioc3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc3/applicationContext.xml");
		Student stu = ac.getBean("stu",Student.class);
		System.out.println(stu);
		Student stu2 = ac.getBean("stu",Student.class);
		System.out.println(stu == stu2);
	}
	@Test
	public void test2(){
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext("ioc3/applicationContext.xml");
		Student stu = ac.getBean("stu",Student.class);
		stu.service();
		//πÿ±’
		ac.close();
	}
	@Test
	public void testt3(){
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext("ioc3/applicationContext.xml");
		
//		Programmer pg = ac.getBean("programmer",Programmer.class);
//		System.out.println(pg);
//		Enginner eg = ac.getBean("enginner",Enginner.class);
//		System.out.println(eg);
		
		Manager mg = ac.getBean("manager",Manager.class);
		System.out.println(mg);
	}
}
