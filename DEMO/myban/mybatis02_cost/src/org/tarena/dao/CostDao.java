package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;

public interface CostDao {
	public Cost findById(Integer cost_id);
	public List<Cost> findAll();
}
