package com.tare.emp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.emp.dao.DeptMapper;
import com.tare.emp.entity.Dept;

/**
 * Dept相关的业务组件
 * @author Administrator
 *
 */
@Service
public class DeptService {
	
	@Resource
	private DeptMapper deptDao;
	
	public List<Dept> findAllDept(){
		List<Dept> depts = deptDao.findAll();
		return depts;
	}
	
	public int saveDept(Dept dept){
		int count = deptDao.saveDept(dept);
		return count;
	}
}
