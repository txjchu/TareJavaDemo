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
	 * �����Զ�װ�䣬���ղ�������װ�����������ϵ��bean����
	 */
	@Test
	public void test2(){

		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
		Zoo zoo = ac.getBean("zoo",Zoo.class);
		zoo.perform();
	}//exist
}
