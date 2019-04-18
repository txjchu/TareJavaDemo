package org.tarena.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Cost;

@Repository("costDao")
public class HibernateCostDao implements CostDao{
	@Resource
	private HibernateTemplate template;//×¢Èë
	
	public List<Cost> findAll() {
		String hql = "from Cost";
		List<Cost> list = template.find(hql);
		return list;
	}

	public void delete(Cost cost) {
		template.delete(cost);
	}

	public Cost findById(Integer id) {
		Cost cost = template.load(Cost.class, id);
		return cost;
	}

	public void save(Cost cost) {
		template.save(cost);
	}

	public void update(Cost cost) {
		template.update(cost);
	}

}
