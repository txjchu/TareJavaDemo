package com.tare.empmgr.dao;

import java.util.Collection;
import java.util.List;

import com.tare.empmgr.annotation.MyBatisRepository;
import com.tare.empmgr.entity.Condition;
import com.tare.empmgr.entity.Emp;

/**
 * 数据表操作的Mapper映射器接口
 * @author Administrator
 *
 */
@MyBatisRepository
public interface EmpMapper {
	
	public List<Emp> findAll();
	public Emp findById(Integer empno);
	public List<Emp> findByDept(Condition con);
	public List<Emp> findBySal(Condition con);
	public List<Emp> findByDeptAndSal(Condition con);
	public void update(Emp emp);
	public List<Emp> findByCondition(Condition con);
	public void update2(Emp emp);
	public List<Emp> findByEmpnos(List<Integer> empnos);//可以将集合封装到Condition类中，然后将该类的对象作为参数传入。
	public List<Emp> findByEmpnos(Condition con);//将empnos集合封装到Condition类中
	public List<Emp> findByEmpnosObj(Object obj);
	
	
	public Emp findByName();
	public void save(Emp emp);
	public void delete(Emp emp);
	public void deleteById(Emp emp);
}
