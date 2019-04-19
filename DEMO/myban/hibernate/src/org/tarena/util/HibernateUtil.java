package org.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;//2������
	static{
		//����Configuration����hibernate.cfg.xml
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//��ȡSessionFactory
		SessionFactory factory = conf.buildSessionFactory();
	}
	public static Session getSession(){
		

		//��ȡSession
		Session session = factory.openSession();
		return session;
		
	}
	
	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session);
		session.close();
	}
	
}
