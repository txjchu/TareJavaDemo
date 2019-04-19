package com.tare.emp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.emp.dao.EmpMapper;
import com.tare.emp.entity.Emp;

/**
 * Emp相关的业务组件
 * @author Administrator
 *
 */
@Service
public class EmpService {
	
	@Resource
	private EmpMapper empMapper;
	
	public List<Emp> findAllEmp(){
		List<Emp> emps = empMapper.findAll();
		return emps;
	}
	public Emp findEmpById(Integer empno){
		Emp emp = empMapper.findById(empno);
		return emp;
	}
	public void saveEmp(Emp emp){
		empMapper.save(emp);
	}
	public void updateEmp(Emp emp){
		empMapper.update(emp);
	}
	public void deleteEmp(Integer empno){
		empMapper.delete(empno);
	}
}
