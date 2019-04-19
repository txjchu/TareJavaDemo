package org.tare.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.bean.DemoBean;
import org.tare.bean.MessageBean;

/**
 * ������
 * @author Administrator
 *
 */
public class TestCase {
	
	/*
	 * �������÷�ʽע�����
	 */
	@Test
	public void test1(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messageBean", MessageBean.class);
		bean.execute();//����ʵ�����bean��execute����
	}
	/*
	 * ����ͨ��util��ǩ����������Ϊbean������ע��bean	 
	 */
	@Test
	public void test2(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("msg", MessageBean.class);
		bean.execute();
	}
	/*
	 * ͨ��Spring���ʽע��bean	field ����
	 */
	@Test
	public void test3(){
		String conf = "org/tare/bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DemoBean bean = ac.getBean("demoBean", DemoBean.class);
		bean.execute();
	}
}
