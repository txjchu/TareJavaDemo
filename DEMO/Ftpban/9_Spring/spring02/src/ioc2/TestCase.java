package ioc2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	//注入简单类型的值,注入对象
	//注入集合类型(list,set,map,props)
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc2/applicationContext.xml");
		MessageBean mb1 = 
			ac.getBean("mb2",MessageBean.class);
		mb1.showInfo();
	}
	
	@Test
	//使用spring表达式来注入参数值
	public void test2(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc2/applicationContext.xml");
		SomeBean someBean1 =
			ac.getBean("someBean1",SomeBean.class);
		System.out.println(someBean1);
	}
}
