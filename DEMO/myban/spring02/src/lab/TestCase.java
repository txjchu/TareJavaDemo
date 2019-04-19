package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	public void test1(){
		ApplicationContext ac =
			new ClassPathXmlApplicationContext();
		UserDAO dao1 = ac.getBean("",UserDAO.class);
		System.out.println(dao1);
	}
}
