package ioc2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	//ע������͵�ֵ,ע�����
	//ע�뼯������(list,set,map,props)
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc2/applicationContext.xml");
		MessageBean mb1 = 
			ac.getBean("mb2",MessageBean.class);
		mb1.showInfo();
	}
	
	@Test
	//ʹ��spring���ʽ��ע�����ֵ
	public void test2(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"ioc2/applicationContext.xml");
		SomeBean someBean1 =
			ac.getBean("someBean1",SomeBean.class);
		System.out.println(someBean1);
	}
}
