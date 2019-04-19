package com.tare.emp.dao;

import java.util.List;

import com.tare.emp.annotation.MyBatisRepository;
import com.tare.emp.entity.Emp;

/**
 * Emp类对应的映射器接口DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface EmpMapper {
	
	List<Emp> findAll();
	void saveEmp(Emp emp);
	Emp findById(int empno);
	Emp findById2(int empno);
}
