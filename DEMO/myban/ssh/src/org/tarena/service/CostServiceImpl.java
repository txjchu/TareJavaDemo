package org.tarena.service;
/**
 * localhost:9080/ssh/cost/fee_list.action
 */
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
						//事务管理此处可以加只读
	public List<Cost> loadCosts(){
		List<Cost> list = costDao.findAll();
		return list;
	}

	@Override
	public Cost loadCost(Integer id) {
		Cost cost = costDao.findById(id);
		return cost;
	}
}
