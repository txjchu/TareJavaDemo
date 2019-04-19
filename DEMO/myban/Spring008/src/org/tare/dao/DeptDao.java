package org.tare.dao;

import java.util.List;

import org.tare.entity.Dept;

/**
 * ʹ��SqlSessionTemplate��Ҫ��Dao���
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
