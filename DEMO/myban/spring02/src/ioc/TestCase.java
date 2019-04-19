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
	/*
	 * 测试自动装配，按照参数类型装配具有依赖关系的bean对象
	 */
	@Test
	public void test2(){

		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
		Zoo zoo = ac.getBean("zoo",Zoo.class);
		zoo.perform();
	}//exist
}
