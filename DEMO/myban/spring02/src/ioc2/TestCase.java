package ioc2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	
	@Test	
	//注入简单类型的值
	public void test1(){
		ApplicationContext ac1 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		MessageBean mb1 = ac1.getBean("mb1",MessageBean.class);
		mb1.showInfo();
	}
	@Test	
	//注入集合类型(list,set,map,props)
	public void test2(){
		ApplicationContext ac2 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		MessageBean mb2 = ac2.getBean("mb2",MessageBean.class);
		mb2.showInfo();
	}
	@Test	
	//使用spring表达式来注入参数值
	public void test3(){
		ApplicationContext ac2 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		SomeBean someBean1 = ac2.getBean("someBean1",SomeBean.class);
		System.out.println(someBean1);	
	}
}
