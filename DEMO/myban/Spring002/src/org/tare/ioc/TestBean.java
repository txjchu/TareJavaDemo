package org.tare.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用来测试注解方式
 * @author Administrator
 *
 */
public class TestBean {
	
	/*
	 * 测试@Component注解 
	 */
	@Test
	public void test1(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		System.out.println("ac:"+ ac);
		ExampleBean bean = ac.getBean("example", ExampleBean.class);
		bean.execute();
		//测试bean的作用域
		ExampleBean bean1 = ac.getBean("example", ExampleBean.class);
		System.out.println(bean == bean1);//true	单例模式-同一个对象	false	多例模式-不同的对象
		
	}
	/*
	 * 测试bean的生命周期，练习@PostConstruct和@PreDestroy
	 */
	@Test
	public void test2(){
		String conf = "org/tare/ioc/applicationContext.xml";
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("ac=="+ ac);
		ExampleBean bean = ac.getBean("example", ExampleBean.class);
		bean.execute();
		ac.close();//destroy方法，必须是单例模式才可以。
	}
	/*
	 * 测试注解注入有依赖关系的参数bean
	 */
	@Test
	public void test3(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("ac=="+ ac);
		//必须将Computer类同时注解标注，不然容器创建bean不成功。
		Programmer p = ac.getBean("programmer", Programmer.class);
		System.out.println("programmer的对象为:"+ p);
		System.out.println("p中computer属性："+ p.getComputer().toString());
	}
	/*
	 * 用来测试setter注解方式
	 */
	@Test
	public void test4(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Teacher t = ac.getBean("teacher", Teacher.class);
		System.out.println("Teacher对象："+ t);
		System.out.println("t的属性computer"+ t.getComputer());
	}
	/*
	 * 用来测试@Resource注解
	 */
	@Test
	public void test5(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Manager m = ac.getBean("manager", Manager.class);
		System.out.println("Manager对象："+ m);
		System.out.println("m的属性computer:"+ m.getComputer());
	}
	/*
	 * 测试@Value注入Spring表达式
	 */
	@Test
	public void test6(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DemoBean bean = ac.getBean("demoBean", DemoBean.class);
		System.out.println("DemoBean对象:"+ bean);
		System.out.println("bean对象的属性"+ bean.getName() +","+ bean.getPhone() +","+ bean.getAge() +","+ bean.getJob());
		//bean对象的属性??????,123456789,22,老师		从文件中读取的中文乱码
	}
	
	/*
	 * 课后练习1：注入集合，使用配置方式
	 */
	@Test
	public void test7(){
		String conf = "org/tare/ioc/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messageBean", MessageBean.class);
		bean.execute();
	}
}
