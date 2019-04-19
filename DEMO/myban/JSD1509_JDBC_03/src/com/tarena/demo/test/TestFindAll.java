package com.tarena.demo.test;

import java.util.List;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestFindAll {

	/**
	 * ���Բ�ѯ���м�¼
	 */
	public static void main(String[] args) {
		
		EmpDao empDao = new EmpDao();
		List<Emp> empList = empDao.findAll();
		System.out.println("���\tְλ\t����\t���ź�");
		
		for(Emp emp:empList){
			System.out.println(emp.getEmpNo()+"\t"+emp.getJob()+"\t"+emp.getSal()
								+"\t"+emp.getDeptNo());
		}
	}
	
}
