package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestFindById {

	/**
	 * 测试：根据empNo查询职员
	 */
	public static void main(String[] args) {
		Integer empNo = 2080;
		EmpDao empDao = new EmpDao();
		Emp emp = empDao.findByEmpNo(empNo);
		System.out.println(emp.getEname());
	}
}
