package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.������ô����bean
 * 2.ΪʲôҪ����������
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
//		Hello hello = new Hello();
//		HelloCn hello = new HelloCn();
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("lab/applicationContext.xml");
		IHello hello = ac.getBean("helloa",IHello.class);
		
		hello.say();
	}
}
