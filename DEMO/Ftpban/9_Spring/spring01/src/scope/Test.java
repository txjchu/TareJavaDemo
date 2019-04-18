package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args  
	 */
	public static void main(String[] args) {
		ApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"scope/applicationContext.xml");
		SomeBean sb1 = 
			ac.getBean("someBean1",SomeBean.class);
		SomeBean sb2 = 
			ac.getBean("someBean1",SomeBean.class);
		System.out.println(sb1 == sb2);
	}

}
