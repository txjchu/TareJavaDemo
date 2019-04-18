package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCost {
	@Test
	public void testSession(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		SessionFactory factory = ac.getBean(
			"sessionFactory",SessionFactory.class);
		Session session = factory.openSession();
		System.out.println(session);
		session.close();
	}
}



