package netctoss.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import netctoss.entity.Cost;
import netctoss.util.HibernateUtil;

/**
 * CostDAO的实现类
 * @author Administrator
 *
 */
public class CostDAOImpl implements CostDAO{

	
	
	public Cost findById(Integer id) {
		Cost cost = null;
		Session session = HibernateUtil.getSession();
		cost = (Cost) session.load(Cost.class, id);//采用了延迟加载。同get方法获取的结果一致。都是可以按Id查找记录。
//		cost = (Cost) session.get(Cost.class, id);//不使用延迟加载，不能缓解操作的并发，不能提升对象对内存的使用率。
//		session.close();
		return cost;
	}

	public Cost findByName(String name) {
		Cost cost = null;
		Session session = HibernateUtil.getSession();
		String hql = "from Cost where name = ?";
		Query query = session.createQuery(hql);
		query.setString(0, name);//条件查询，Hibernate的HQL语句中参数?的下标是从0开始的。
		cost = (Cost) query.list().iterator().next();//使用query的条件查询API获取到的结果集是集合，使用迭代器后获取集合中的第一个元素，即我们要查询的记录。
//		session.close();
		return cost;
	}
	
	public boolean update(Cost cost) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println("update:"+ cost);
		try {
			session.update(cost);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
//			session.close();
		}
	}
	
	
	public boolean save(Cost cost) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(cost);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public void delete(int id) {
		//模拟删除某项资费
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Cost cost = findById(id);
		try {
			session.delete(cost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
//			session.close();
		}
		
	}

	public List<Cost> findAll() {
        List<Cost> list = new ArrayList<Cost>();
        Session session = HibernateUtil.getSession();
        String hql = "from Cost";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
	}
	
	
}
