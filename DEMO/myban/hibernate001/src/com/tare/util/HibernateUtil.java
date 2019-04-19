package com.tare.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类，主要用于获取Session对象，以便后续操作。将重复性的代码工作抽离出来作为工具类。
 * @author Administrator
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		//加载Hibernate主配置文件
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	//创建session的方法
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	
	public static void main(String[] args) {
		System.out.println(getSession());
	}
}
