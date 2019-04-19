package com.tare.emp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.emp.dao.EmpMapper;
import com.tare.emp.entity.Emp;

/**
 * Emp相关的业务层组件
 * @author Administrator
 *
 */
@Service
public class EmpService {

	@Resource
	private EmpMapper empDao;
	
	public List<Emp> findAllEmp(){
		List<Emp> emps = empDao.findAll();
		return emps;
	}
	public void save(Emp emp){
		empDao.saveEmp(emp);
		
	}
}
