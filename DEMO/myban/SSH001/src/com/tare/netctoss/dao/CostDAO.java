package com.tare.netctoss.dao;

import java.util.List;

import com.tare.netctoss.entity.Cost;

/**
 * Cost类的DAO
 * @author Administrator
 *
 */
public interface CostDAO {

	List<Cost> findAll();//查询所有资费记录
	
	Cost findById(Integer id);//按ID查询出某条记录
	
	void updateStatus(Integer id);//根据ID修改开通暂停状态
	
	List<Cost> findByName(String name);//按资费名称查询出某条记录，用于检查资费名称是否重复
	
	int findTotalPage(int pageSize);//查询总页数
	
	List<Cost> findByPage(int page, int pageSize);//按页数和页容量查询指定的第几页的记录
	
	void save(Cost cost);//保存某条记录
	
	void update(Cost cost);//更新某条记录
	
	void delete(Integer cost_id);//删除某条记录
	
}
