package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import factory.Student;

/**
 * 测试创建ApplicationContext对象
 * @author Administrator
 *
 */
public class testCase {
	
	/*
	 * 实例化容器
	 */
	@Test
	public void test1(){
		//配置时候路径一定要正确。xml文件的路径扫描是从src文件下开始的。若在包里面，则路径应该加上包名/。
		String config = "test/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		System.out.println(ac);
	}
	
	/*
	 * bean的实例化：构造器，静态工厂方法，动态工厂方法
	 */
	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Calendar cal1 = (Calendar) ac.getBean("obj");
		System.out.println(cal1);
		
		Calendar cal2 = (Calendar) ac.getBean("obj1");
		System.out.println(cal2);
		
		Date obj3 = (Date) ac.getBean("obj3");
		System.out.println(obj3);
	}
	/*
	 * bean的作用域：
	 * 默认singleton单例模式，不管获取多少次，获取的bean只要标识符一致，都是同一个对象。
	 * prototype多例模式，即每一次获取的bean对象都是一个新的bean对象。
	 */
	@Test
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Calendar cal1 = (Calendar) ac.getBean("obj4");
		Calendar cal2 = (Calendar) ac.getBean("obj4");
		System.out.println(cal1 == cal2);		//true	单例模式	false	多例模式
		System.out.println(cal1.equals(cal2));	//true	单例模式	true	多例模式
	}
	/*
	 * bean的生命周期回调
	 * 
	 */
	@Test
	public void test5(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		System.out.println("--------分割线：容器已经启动，若设定了延迟实例化，则此时bean还未实例化。----------");
		ExampleBean b1 = (ExampleBean) ac.getBean("exampleBean");
		System.out.println(b1);
		b1.execute();//执行例子bean中的执行方法
		ac.close();
	}
	/*
	 * bean的:通过setter方式注入
	 */
	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Computer computer = ac.getBean("computer", Computer.class);
		System.out.println(computer);
	}
	/*
	 * 构造器注入
	 */
	@Test
	public void test6(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		MobilePhone mp = ac.getBean("mobilePhone", MobilePhone.class);
		System.out.println(mp);
	}
	/*
	 * 自动装载具有依赖关系的bean
	 */
	@Test
	public void test7(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Student s = ac.getBean("student", Student.class);
		System.out.println(s);
	}
	
	
}










