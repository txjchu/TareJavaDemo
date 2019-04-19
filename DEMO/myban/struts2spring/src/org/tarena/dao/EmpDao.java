package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Emp;

public interface EmpDao {
	public List<Emp> findAll();
	public int delete(int no);
}
