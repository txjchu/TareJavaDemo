package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

/**
 * 测试：根据empNo查询职员
 * @author Administrator
 *
 */
public class TestFindById {
	public static void main(String[] args) {
		
		Integer empNo = 2000;
		EmpDao empDao = new EmpDao();
		Emp emp = empDao.findByEmpNo(empNo);
		System.out.println(emp.getEname());
		
		
		
	}
}
