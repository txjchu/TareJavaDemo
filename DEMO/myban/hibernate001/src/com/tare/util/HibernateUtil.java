package com.tare.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * �����࣬��Ҫ���ڻ�ȡSession�����Ա�������������ظ��ԵĴ��빤�����������Ϊ�����ࡣ
 * @author Administrator
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		//����Hibernate�������ļ�
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	//����session�ķ���
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	
	public static void main(String[] args) {
		System.out.println(getSession());
	}
}
