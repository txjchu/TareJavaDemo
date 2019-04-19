package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * 加main方法测试
	 * @param args 
	 */
	public static void main(String[] args) {
		//----启动容器，并调用配置文件
		ApplicationContext ac = 		
			new ClassPathXmlApplicationContext("scope/applicationContext.xml");
		
		//容器在默认情况下，每一个bean的定义会创建一个对应的实例。
		SomeBean sb1 = ac.getBean("someBean1",SomeBean.class);		
		SomeBean sb2 = ac.getBean("someBean1",SomeBean.class);	//当作用域为多例时，几次getBean就会创建几个bean。
		
		System.out.println(sb1 == sb2);
		
	}

}
