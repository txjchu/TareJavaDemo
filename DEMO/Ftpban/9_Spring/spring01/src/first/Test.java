package first;

import java.util.Date;
import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * 启动spring容器。
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"first/applicationContext.xml");
		//System.out.println(ac);
		//向容器要求获得一个实例
		Dog dog1 = ac.getBean("dog1",Dog.class);
		dog1.cry();
		Cat cat1 = ac.getBean("cat1",Cat.class);
		cat1.cry();
		Calendar cal1 = 
			ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
		
		Calendar cal2 = 
			ac.getBean("cal2",Calendar.class);
		System.out.println(cal2);
		
		Date date1 = 
			ac.getBean("date1",Date.class);
		System.out.println(date1);
	}

}
