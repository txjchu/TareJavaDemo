package org.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static{
		//Configuration
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//SessionFactory
		factory = conf.buildSessionFactory();
	}
	
	//使用同一个SessionFactory创建多个不同的Session
	public static Session getSession(){
		System.out.println(factory);
		
		//Session
		Session session = factory.openSession();
		return session;
	}
}
