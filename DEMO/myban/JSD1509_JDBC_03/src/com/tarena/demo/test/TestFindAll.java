package com.tarena.demo.test;

import java.util.List;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestFindAll {

	/**
	 * 测试查询所有记录
	 */
	public static void main(String[] args) {
		
		EmpDao empDao = new EmpDao();
		List<Emp> empList = empDao.findAll();
		System.out.println("编号\t职位\t工资\t部门号");
		
		for(Emp emp:empList){
			System.out.println(emp.getEmpNo()+"\t"+emp.getJob()+"\t"+emp.getSal()
								+"\t"+emp.getDeptNo());
		}
	}
	
}
