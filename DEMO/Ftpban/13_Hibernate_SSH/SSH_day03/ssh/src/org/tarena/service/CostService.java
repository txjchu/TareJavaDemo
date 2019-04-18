package org.tarena.service;

import java.util.List;

import org.tarena.entity.Cost;

public interface CostService {
	
	public List<Cost> loadCosts();
	
	public Cost loadCost(Integer id);
	
}
