package com.tare.netctoss.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tare.netctoss.entity.Cost;

/**
 * CostDAO��ʵ���࣬�̳�HibernateDaoSupport,ʵ��CostDAO
 * @author Administrator
 *
 */
@Repository
public class ICostDAO extends HibernateDaoSupport implements CostDAO{

	@Resource
	private SessionFactory sessionFactory;
						   
	/*
	 * ʹ��Spring�Զ�ע��һ��sessionFactory���÷����ǹ̶�����ǩ����
	 */
	@Resource
	public void setSF(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	
	public void updateStatus(Integer id) {
		Cost cost = findById(id);//ͨ��ID��ȡ������¼
		String status = cost.getStatus();
		if("0".equals(status)){
			cost.setStatus("1");
			cost.setStartime(null);
		} else {
			cost.setStatus("0");
			cost.setStartime(new Date(System.currentTimeMillis()));//���ÿ�ͨʱ��Ϊ��ǰʱ��㡣
		}
		update(cost);//��������
	}

	public int findTotalPage(int pageSize) {
		String hql = "select count(*) from Cost";
		List<Object> list = getHibernateTemplate().find(hql);//���������У�����һ�������С�
		int rows = Integer.valueOf(list.get(0).toString());//��ȡ������
		if(rows % pageSize == 0){
			return rows / pageSize;
		} else {
			return rows / pageSize + 1;
		}
	}

	public List<Cost> findByName(String name) {
		String hql = "from Cost where name = '"+ name +"'";
		List<Cost> list = getHibernateTemplate().find(hql);
		return list;
	}

	public List<Cost> findByPage(final int page, final int pageSize) {
		//ģ��������쳣���������쳣�������Ƿ�ɹ�
//		Integer.valueOf("abc");
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Cost";
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1)* pageSize);
				query.setMaxResults(pageSize);
				return query.list();				
			}			
		}); 		
	}


	public void delete(Integer costId) {
		Cost c = new Cost();
		c.setCost_id(costId);
		getHibernateTemplate().delete(c);
	}

	public List<Cost> findAll() {
		String hql = "from Cost";
		return getHibernateTemplate().find(hql);
	}

	public Cost findById(Integer id) {
		return getHibernateTemplate().load(Cost.class, id);//load�������ӳټ��صķ�ʽ��
	}

	public void save(Cost cost) {
		if(cost == null)
			return;
		getHibernateTemplate().save(cost);		
	}

	public void update(Cost cost) {
		if(cost == null)
			return;
		getHibernateTemplate().update(cost);
	}
	
	

}
