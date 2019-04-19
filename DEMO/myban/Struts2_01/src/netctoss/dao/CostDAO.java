package netctoss.dao;

import java.util.List;

import netctoss.entity.Cost;

/**
 * Cost表相关数据操作DAO组件接口
 * @author Administrator
 *
 */
public interface CostDAO {
	
	List<Cost> findAll();//查询所有资费的方法
	void delete(int id);//删除某项资费的方法
	Cost findByName(String name);//按资费名查找资费记录的方法
	Cost findById(Integer id);
	boolean update(Cost cost);
	boolean save(Cost cost);
	
}
