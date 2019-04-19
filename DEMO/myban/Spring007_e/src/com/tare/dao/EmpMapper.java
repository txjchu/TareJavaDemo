package com.tare.dao;

import java.util.List;

import com.tare.entity.Emp;

/**
 * EmpµÄMapperÓ³ÉäÆ÷
 * @author Administrator
 *
 */
public interface EmpMapper {

	public List<Emp> findAll();
	public Emp findById(Integer id);
	public Emp findByName(String name);
	public void update(Emp emp);//update
	public void save(Emp emp);
	public void delete(Integer id);
}
