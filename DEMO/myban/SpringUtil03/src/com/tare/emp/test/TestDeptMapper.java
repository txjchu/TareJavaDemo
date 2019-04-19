package com.tare.emp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.emp.dao.DeptMapper;
import com.tare.emp.entity.Dept;
import com.tare.emp.entity.Emp;

public class TestDeptMapper {
	
	private DeptMapper deptDao;
	
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		deptDao = ac.getBean(DeptMapper.class);
	}
	@Test
	public void testtFindAll(){
		List<Dept> depts = deptDao.findAll();
		for(Dept d : depts){
			System.out.println(d);
		}
	}
	@Test
	public void testFindById(){
		Dept dept = deptDao.findById(10);
		List<Emp> emps = dept.getEmps();
		for(Emp e : emps){
			System.out.println(dept +"="+ e);
		}
	}
	@Test
	public void testFindById2(){
		Dept dept = deptDao.findById2(10);
		List<Emp> emps = dept.getEmps();
		for(Emp e : emps){
			System.out.println(dept +"="+ e);
		}
	}
}
