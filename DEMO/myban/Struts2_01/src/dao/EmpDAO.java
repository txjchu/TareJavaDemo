package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Emp;

import netctoss.util.HibernateUtil;

/**
 * Emp¶ÔÓ¦µÄDAO
 * @author Administrator
 *
 */
public class EmpDAO {

	public List<Emp> findAll(){
		Session session = HibernateUtil.getSession();
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		List<Emp> emps = query.list();
		return emps;
	}
}
