package netctoss.dao;

import java.util.List;

import netctoss.entity.Cost;

/**
 * 套餐CostDAO
 * @author Administrator
 *
 */
public interface CostDAO {
	
	//查询所有的套餐
	List<Cost> findAll();
}
