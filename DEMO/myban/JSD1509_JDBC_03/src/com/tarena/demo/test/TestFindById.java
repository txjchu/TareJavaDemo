package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

/**
 * ���ԣ�����empNo��ѯְԱ
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
