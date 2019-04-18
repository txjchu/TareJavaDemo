package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;

public interface CostDao {
	public List<Cost> findAll();
	public Cost findById(Integer id);
	public int save(Cost cost);
}
