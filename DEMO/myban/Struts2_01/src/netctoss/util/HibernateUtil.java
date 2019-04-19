package netctoss.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate�Ĺ����࣬������ȡSession
 * @author Administrator
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	static{
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	public static Session getSession(){
		//ThreadLocal���Ե�ǰ�߳���Ϊkey����ȡ���ӡ�
		Session session = tl.get();
		//�����ȡ���ĵ�ǰ�߳�Ϊ�ա�
		if(session == null){
			//ʹ�ù�������session
			session = sessionFactory.openSession(); 
			//ThreadLocal���Ե�ǰ�߳���Ϊkey��������session��
			tl.set(session);
		}
		return session;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void close(){
		Session session = tl.get();
		if(session != null){
			session.close();
			tl.remove();//����ǰ�̶߳�Ӧ�����Ӵ�ThreadLocal���Ƴ���
		}
	}
	
	public static void main(String[] args) {
		/*
		 * ��xxx.hbm.xml��û���������ʱ��ȴ�������hibernate.cfg.xml�������ˣ���ʱʵ����session����쳣��
		 * Exception in thread "main" java.lang.ExceptionInInitializerError
		 * Caused by: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		 */
		System.out.println(getSession());
	}
}
