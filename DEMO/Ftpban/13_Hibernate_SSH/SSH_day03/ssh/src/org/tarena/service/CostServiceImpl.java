package org.tarena.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;

@Service("costService")
@Transactional
public class CostServiceImpl implements CostService{
	@Resource
	private CostDao costDao;
	
	public List<Cost> loadCosts() {
		List<Cost> list = costDao.findAll();
		return list;
	}

	public Cost loadCost(Integer id) {
		Cost cost = costDao.findById(id);
		return cost;
	}

}
