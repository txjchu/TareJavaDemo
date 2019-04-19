package org.tare.dao;

import java.util.List;

import org.tare.entity.Dept;

/**
 * 使用SqlSessionTemplate需要的Dao组件
 * @author Administrator
 *
 */
public interface DeptDao {
	
	List<Dept> findAll();
	Dept findById(Integer deptno);
	int save(Dept dept);
	int update(Dept dept);
	void delete(Integer deptno);
}
