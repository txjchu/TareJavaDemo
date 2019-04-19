package com.tare.emp.dao;

import java.util.List;

import com.tare.emp.annotation.MyBatisRepository;
import com.tare.emp.entity.Emp;

/**
 * Emp��صĲ������ݿ�����DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface EmpMapper {
	
	List<Emp> findAll();
	Emp findById(Integer empno);
	void save(Emp emp);
	void update(Emp emp);
	void delete(Integer empno);
}
