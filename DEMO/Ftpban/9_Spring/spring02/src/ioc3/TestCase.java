package ioc3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
}
