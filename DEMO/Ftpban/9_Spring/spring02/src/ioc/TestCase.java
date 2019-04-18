package ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		Zoo zoo = new Zoo();
		zoo.perform();
	}
	
	@Test
	public void test2(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc/applicationContext.xml");
		Zoo zoo = ac.getBean("zoo",Zoo.class);
		zoo.perform();
	}
}
