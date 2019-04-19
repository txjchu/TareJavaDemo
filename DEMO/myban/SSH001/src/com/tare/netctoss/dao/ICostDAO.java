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
 * CostDAO的实现类，继承HibernateDaoSupport,实现CostDAO
 * @author Administrator
 *
 */
@Repository
public class ICostDAO extends HibernateDaoSupport implements CostDAO{

	@Resource
	private SessionFactory sessionFactory;
						   
	/*
	 * 使用Spring自动注入一个sessionFactory，该方法是固定方法签名。
	 */
	@Resource
	public void setSF(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	
	public void updateStatus(Integer id) {
		Cost cost = findById(id);//通过ID获取该条记录
		String status = cost.getStatus();
		if("0".equals(status)){
			cost.setStatus("1");
			cost.setStartime(null);
		} else {
			cost.setStatus("0");
			cost.setStartime(new Date(System.currentTimeMillis()));//设置开通时间为当前时间点。
		}
		update(cost);//更新数据
	}

	public int findTotalPage(int pageSize) {
		String hql = "select count(*) from Cost";
		List<Object> list = getHibernateTemplate().find(hql);//计算所有行，放入一个集合中。
		int rows = Integer.valueOf(list.get(0).toString());//获取总行数
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
		//模拟出现抛异常情况，检测异常拦截器是否成功
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
		return getHibernateTemplate().load(Cost.class, id);//load方法是延迟加载的方式。
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
