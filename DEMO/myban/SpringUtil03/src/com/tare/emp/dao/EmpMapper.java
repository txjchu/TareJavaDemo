package com.tare.emp.dao;

import java.util.List;

import com.tare.emp.annotation.MyBatisRepository;
import com.tare.emp.entity.Emp;

/**
 * Emp���Ӧ��ӳ�����ӿ�DAO
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
