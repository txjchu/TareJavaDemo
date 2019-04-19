package org.tare.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.bean.DemoBean;
import org.tare.bean.MessageBean;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestCase {
	
	/*
	 * 测试配置方式注入参数
	 */
	@Test
	public void test1(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messageBean", MessageBean.class);
		bean.execute();//调用实体对象bean的execute方法
	}
	/*
	 * 测试通过util标签将集合配置为bean后，引用注入bean	 
	 */
	@Test
	public void test2(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("msg", MessageBean.class);
		bean.execute();
	}
	/*
	 * 通过Spring表达式注入bean	field 领域
	 */
	@Test
	public void test3(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DemoBean bean = ac.getBean("demoBean", DemoBean.class);
		bean.execute();
	}
}
