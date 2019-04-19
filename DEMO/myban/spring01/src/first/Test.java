package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * ����Spring����
	 */
	public static void main(String[] args) {
		//����һ��ApplicationContext������ʵ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("first/applicationContext.xml");
		System.out.println(ac);
		
		//������Ҫ����һ��dogʵ��
		Dog dog1 = ac.getBean("dog1",Dog.class);//----�Ӹ�������Dog.class,�����Ͳ���ǿ��ת�������ˡ�
		dog1.cry();
		
		Cat cat1 = ac.getBean("cat1",Cat.class);
		cat1.cry();
		
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
		
		Calendar cal2 = ac.getBean("cal2",Calendar.class);
		System.out.println(cal2);
		
		Date date1 = ac.getBean("date1",Date.class);
		System.out.println(date1);
	}

}
