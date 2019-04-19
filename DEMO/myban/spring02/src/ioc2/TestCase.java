package ioc2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	
	@Test	
	//ע������͵�ֵ
	public void test1(){
		ApplicationContext ac1 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		MessageBean mb1 = ac1.getBean("mb1",MessageBean.class);
		mb1.showInfo();
	}
	@Test	
	//ע�뼯������(list,set,map,props)
	public void test2(){
		ApplicationContext ac2 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		MessageBean mb2 = ac2.getBean("mb2",MessageBean.class);
		mb2.showInfo();
	}
	@Test	
	//ʹ��spring���ʽ��ע�����ֵ
	public void test3(){
		ApplicationContext ac2 = 
			new ClassPathXmlApplicationContext("ioc2/applicationContext.xml");
		SomeBean someBean1 = ac2.getBean("someBean1",SomeBean.class);
		System.out.println(someBean1);	
	}
}
