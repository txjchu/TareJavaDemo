package com.tare.netctoss.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tare.netctoss.entity.Admin;

/**
 * LogDAO的实现类
 * @author Administrator
 *
 */
@Repository
public class ILoginDAO extends HibernateDaoSupport implements LoginDAO{
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	public void setSF(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/*
	 * 查找全部记录的用法，find(hql)
	 */
	public List<Admin> findAll() {
		String hql = "from Admin";
		return getHibernateTemplate().find(hql);
	}

	public Admin findByCode(String adminCode) {
		String hql = "from Admin where admin_code = '"+ adminCode +"'";
		
		return (Admin) getHibernateTemplate().find(hql).iterator().next();//假定admin_code有唯一性约束。获取到的list中只有1个元素。
	}
}
