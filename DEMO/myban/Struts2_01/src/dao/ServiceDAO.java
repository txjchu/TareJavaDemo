package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import netctoss.util.HibernateUtil;

import entity.Service;

/**
 * Service类的DAO
 * @author Administrator
 *
 */
public class ServiceDAO {
	
	public List<Service> findAll(){
		Session session = HibernateUtil.getSession();
		String hql = "from Service";
		Query query = session.createQuery(hql);
		List<Service> services = query.list();//非延迟加载方法
//		session.close();
		return services;
	}
	
	public Service findById(Integer service_id){
		Session session = HibernateUtil.getSession();
		/*
		 * 非延迟加载方法，但是默认关联属性的查询是延迟加载的。因此当在此方法中关闭了session后，当要访问关联属性时，
		 * 会出异常，no session.
		 */
		Service service = (Service) session.get(Service.class, service_id);
//		session.close();
		return service;
	}
	public List<Service> findByName(String unix_host){
		Session session = HibernateUtil.getSession();
		String hql = "from Service where unix_host = ?";
		Query query = session.createQuery(hql);
		query.setString(0, unix_host);
		List<Service> ss = query.list();
		return ss;
	}
	
	public void save(Service service){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.save(service);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("进入了ServiceDAO的save方法异常中了。");
			ts.rollback();
		} 
//		finally{
//			session.close();
//		}
	}
}
