package org.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Session getSession(){
		//Configuration加载hibernate.cfg.xml
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//获取SessionFactory
		SessionFactory factory = 
			conf.buildSessionFactory();
		//获取Session
		Session session = factory.openSession();
		return session;
	}
	
	public static void main(String[] args){
		Session session = getSession();
		System.out.println(session);
		session.close();
	}
	






	
}
