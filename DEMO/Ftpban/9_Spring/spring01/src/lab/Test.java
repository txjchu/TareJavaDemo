package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"lab/applicationContext.xml");
		IHello hello = ac.getBean("hello",IHello.class);
		hello.say();
	}

}
