package netctoss.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import netctoss.entity.Cost;
import netctoss.util.HibernateUtil;

/**
 * CostDAO��ʵ����
 * @author Administrator
 *
 */
public class CostDAOImpl implements CostDAO{

	
	
	public Cost findById(Integer id) {
		Cost cost = null;
		Session session = HibernateUtil.getSession();
		cost = (Cost) session.load(Cost.class, id);//�������ӳټ��ء�ͬget������ȡ�Ľ��һ�¡����ǿ��԰�Id���Ҽ�¼��
//		cost = (Cost) session.get(Cost.class, id);//��ʹ���ӳټ��أ����ܻ�������Ĳ�������������������ڴ��ʹ���ʡ�
//		session.close();
		return cost;
	}

	public Cost findByName(String name) {
		Cost cost = null;
		Session session = HibernateUtil.getSession();
		String hql = "from Cost where name = ?";
		Query query = session.createQuery(hql);
		query.setString(0, name);//������ѯ��Hibernate��HQL����в���?���±��Ǵ�0��ʼ�ġ�
		cost = (Cost) query.list().iterator().next();//ʹ��query��������ѯAPI��ȡ���Ľ�����Ǽ��ϣ�ʹ�õ��������ȡ�����еĵ�һ��Ԫ�أ�������Ҫ��ѯ�ļ�¼��
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
		//ģ��ɾ��ĳ���ʷ�
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
