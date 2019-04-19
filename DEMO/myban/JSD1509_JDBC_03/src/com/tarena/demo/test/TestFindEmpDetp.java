package com.tarena.demo.test;

import java.util.List;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

/**
 * 测试：查询员工以及所在的部门信息
 * @author Administrator
 *
 */
public class TestFindEmpDetp {
	public static void main(String[] args) {
		
		EmpDao empDao = new EmpDao();
		List<Emp> empList = empDao.findEmpDept();
		for (Emp emp:empList){
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getJob()+"\t");
			System.out.print(emp.getSal()+"\t");
			System.out.print(emp.getDept().getDname()+"\t");
			System.out.print(emp.getDept().getLoc()+"\t");
			System.out.println();
			
		}
		
		
		
		
	}
}
