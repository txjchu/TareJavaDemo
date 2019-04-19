package org.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;//2级缓存
	static{
		//利用Configuration加载hibernate.cfg.xml
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//获取SessionFactory
		SessionFactory factory = conf.buildSessionFactory();
	}
	public static Session getSession(){
		

		//获取Session
		Session session = factory.openSession();
		return session;
		
	}
	
	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session);
		session.close();
	}
	
}
