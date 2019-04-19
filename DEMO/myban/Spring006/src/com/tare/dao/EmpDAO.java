package com.tare.dao;

import java.util.List;

import com.tare.entity.Emp;

/**
 * EmpDAO½Ó¿Ú
 * @author Administrator
 *
 */
public interface EmpDAO {
	
	List<Emp> findAll();
	Emp findById(int id);
	void save(Emp emp);
	void update(Emp emp);
	void delete(int id);
}
