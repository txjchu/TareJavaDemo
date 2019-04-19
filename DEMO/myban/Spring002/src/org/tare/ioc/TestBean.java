package org.tare.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��������ע�ⷽʽ
 * @author Administrator
 *
 */
public class TestBean {
	
	/*
	 * ����@Componentע�� 
	 */
	@Test
	public void test1(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		System.out.println("ac:"+ ac);
		ExampleBean bean = ac.getBean("example", ExampleBean.class);
		bean.execute();
		//����bean��������
		ExampleBean bean1 = ac.getBean("example", ExampleBean.class);
		System.out.println(bean == bean1);//true	����ģʽ-ͬһ������	false	����ģʽ-��ͬ�Ķ���
		
	}
	/*
	 * ����bean���������ڣ���ϰ@PostConstruct��@PreDestroy
	 */
	@Test
	public void test2(){
		String conf = "org/tare/ioc/applicationContext.xml";
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("ac=="+ ac);
		ExampleBean bean = ac.getBean("example", ExampleBean.class);
		bean.execute();
		ac.close();//destroy�����������ǵ���ģʽ�ſ��ԡ�
	}
	/*
	 * ����ע��ע����������ϵ�Ĳ���bean
	 */
	@Test
	public void test3(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("ac=="+ ac);
		//���뽫Computer��ͬʱע���ע����Ȼ��������bean���ɹ���
		Programmer p = ac.getBean("programmer", Programmer.class);
		System.out.println("programmer�Ķ���Ϊ:"+ p);
		System.out.println("p��computer���ԣ�"+ p.getComputer().toString());
	}
	/*
	 * ��������setterע�ⷽʽ
	 */
	@Test
	public void test4(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Teacher t = ac.getBean("teacher", Teacher.class);
		System.out.println("Teacher����"+ t);
		System.out.println("t������computer"+ t.getComputer());
	}
	/*
	 * ��������@Resourceע��
	 */
	@Test
	public void test5(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Manager m = ac.getBean("manager", Manager.class);
		System.out.println("Manager����"+ m);
		System.out.println("m������computer:"+ m.getComputer());
	}
	/*
	 * ����@Valueע��Spring���ʽ
	 */
	@Test
	public void test6(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DemoBean bean = ac.getBean("demoBean", DemoBean.class);
		System.out.println("DemoBean����:"+ bean);
		System.out.println("bean���������"+ bean.getName() +","+ bean.getPhone() +","+ bean.getAge() +","+ bean.getJob());
		//bean���������??????,123456789,22,��ʦ		���ļ��ж�ȡ����������
	}
	
	/*
	 * �κ���ϰ1��ע�뼯�ϣ�ʹ�����÷�ʽ
	 */
	@Test
	public void test7(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messageBean", MessageBean.class);
		bean.execute();
	}
}
