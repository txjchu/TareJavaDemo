package org.tare.dao;

import java.util.List;

import org.tare.entity.Emp;

/**
 * Emp类的Mapper映射器接口
 * @author Administrator
 *
 */
public interface EmpMapper {
	
	public List<Emp> findAll();
	public Emp findById(Integer empno);
	public Emp findByName(String ename);
	public int save(Emp emp);
	public int update(Emp emp);
	public int deleteById(Integer empno);
	public int delete(Emp emp);
}
