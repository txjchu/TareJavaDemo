package com.tare.empmgr.dao;

import java.util.Collection;
import java.util.List;

import com.tare.empmgr.annotation.MyBatisRepository;
import com.tare.empmgr.entity.Condition;
import com.tare.empmgr.entity.Emp;

/**
 * ���ݱ������Mapperӳ�����ӿ�
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
	public List<Emp> findByEmpnos(List<Integer> empnos);//���Խ����Ϸ�װ��Condition���У�Ȼ�󽫸���Ķ�����Ϊ�������롣
	public List<Emp> findByEmpnos(Condition con);//��empnos���Ϸ�װ��Condition����
	public List<Emp> findByEmpnosObj(Object obj);
	
	
	public Emp findByName();
	public void save(Emp emp);
	public void delete(Emp emp);
	public void deleteById(Emp emp);
}
