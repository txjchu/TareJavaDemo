package life;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ApplicationContext ac =
//			new ClassPathXmlApplicationContext(
//					"life/applicationContext.xml");
//		LifeBean lb = 
//			ac.getBean("lifeBean",LifeBean.class);
//		lb.service();
		
		AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext(
					"life/applicationContext.xml");
		LifeBean lb = 
			ac.getBean("lifeBean",LifeBean.class);
//		lb.service();
//		//¹Ø±ÕÈÝÆ÷
//		ac.close();
	}

}
