package com.tare.emp.dao;

import java.util.List;

import com.tare.emp.entity.Dept;
import com.tare.emp.annotation.MyBatisRepository;

/**
 * Dept��Ӧ��Mapperӳ�����ӿ�DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface DeptMapper {
	List<Dept> findAll();
	Dept findById(Integer deptno);
	Dept findById2(Integer deptno);
	int saveDept(Dept dept);
}
