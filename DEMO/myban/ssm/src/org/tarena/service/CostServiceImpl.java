package org.tarena.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;
@Service
public class CostServiceImpl implements CostService {
	
	@Resource
	private CostDao costDao;
	
	public List<Cost> loadCosts() {
		List<Cost> costs = costDao.findAll();
		return costs;
	}
	
}
