package netctoss.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的工具类，用来获取Session
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
		//ThreadLocal会以当前线程名为key，获取连接。
		Session session = tl.get();
		//如果获取到的当前线程为空。
		if(session == null){
			//使用工厂创建session
			session = sessionFactory.openSession(); 
			//ThreadLocal会以当前线程名为key，并保存session。
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
			tl.remove();//将当前线程对应的连接从ThreadLocal中移除。
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 当xxx.hbm.xml还没有配置完成时，却将其放入hibernate.cfg.xml中声明了，此时实例化session会出异常：
		 * Exception in thread "main" java.lang.ExceptionInInitializerError
		 * Caused by: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		 */
		System.out.println(getSession());
	}
}
