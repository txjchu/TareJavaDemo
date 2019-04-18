package di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"di/applicationContext.xml");
		Computer c = 
			ac.getBean("computer",Computer.class);
		System.out.println(c);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"di/applicationContext.xml");
		MobilePhone mp = 
			ac.getBean("mobilePhone",MobilePhone.class);
		System.out.println(mp);
	}
	
	@Test
	public void test3(){
		ApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"di/applicationContext.xml");
		Student stu = 
			ac.getBean("student",Student.class);
		System.out.println(stu);
	}
}
