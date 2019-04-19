package di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	
	//setter方法注入，更加灵活
	@Test//----表示这是一个测试方法。invalid
	public void test1(){
		//启动容器
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("di/applicationContext.xml");
		
		Computer c = ac.getBean("computer",Computer.class);
		System.out.println(c);
		
	}
	
	//用构造器方式注入，比较强制。必须要赋值
	@Test//----表示这是一个测试方法。invalid
	public void test2(){
		//启动容器
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("di/applicationContext.xml");
		
		MobilePhone mp = ac.getBean("mobilePhone",MobilePhone.class);
		System.out.println(mp);
		
	}
	
	//依赖注入----将对象的关系交给容器来管理。
	@Test//----表示这是一个测试方法。invalid
	public void test3(){
		//启动容器
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("di/applicationContext.xml");
		
		Student stu = ac.getBean("student",Student.class);
		System.out.println(stu);
		
	}
}
