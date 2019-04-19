package org.tarena.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Cost;

@Repository("costDao")
public class HibernateCostDao implements CostDao{
	@Resource
	private HibernateTemplate template;//��Spring����ע��
	@Override
	public List<Cost> findAll() {
		String hql = "from Cost";	//Cost������
		List<Cost> list = template.find(hql);//��װ�˻�ȡsession��ִ��session���ͷ�session��		
		return list;
	}
	@Override
	public void delect(Cost cost) {
		template.delete(cost);
		
	}
	@Override
	public Cost findById(Integer id) {
		Cost cost = template.load(Cost.class, id);
		return cost;
	}
	@Override
	public void save(Cost cost) {
		template.save(cost);
		
	}
	@Override
	public void update(Cost cost) {
		template.update(cost);
		
	}
	
	
}
