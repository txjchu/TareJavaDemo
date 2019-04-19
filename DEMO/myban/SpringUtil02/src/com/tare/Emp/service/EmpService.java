package com.tare.Emp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.Emp.dao.EmpMapper;
import com.tare.Emp.entity.Emp;

/**
 * Emp��ص�ҵ������
 * @author Administrator
 *
 */
@Service
public class EmpService {
	
	@Resource
	private EmpMapper empDao;
	
	public List<Emp> loadList(){
		List<Emp> emps = empDao.findAll();
		return emps;
	}
}
