package com.tare.Emp.dao;

import java.util.List;

import com.tare.Emp.annotation.MyBatisRepository;
import com.tare.Emp.entity.Dept;
import com.tare.Emp.entity.Emp;

/**
 * Dept类的操作数据库的DAO映射器组件
 * @author Administrator
 *
 */
@MyBatisRepository
public interface DeptMapper {
 
	List<Dept> findAll();
	Dept findById(Integer deptno);
	Dept findById2(Integer deptno);
	
}
