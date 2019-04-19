package com.tare.Emp.dao;

import java.util.List;

import com.tare.Emp.annotation.MyBatisRepository;
import com.tare.Emp.entity.Emp;

/**
 * Emp��������ݿ��ӳ�����ӿ�
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
