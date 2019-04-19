package com.tare.emp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.emp.dao.EmpMapper;
import com.tare.emp.entity.Emp;

/**
 * 测试类：Emp相关
 * @author Administrator
 *
 */
public class TestEmpMapper {

	private EmpMapper empDao;
	
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		empDao = ac.getBean(EmpMapper.class);
	}
	@Test
	public void testFindAllEmp(){
		List<Emp> emps = empDao.findAll();
		for(Emp e : emps){
			System.out.println(e +","+ e.getDept());//findAll()方法中没有查询Dept的信息。输出为null
		}
	} 
	@Test
	public void testFindById(){
		Emp emp = empDao.findById(3739);
		System.out.println(emp +","+ emp.getDept());
	}
	@Test
	public void testFindById2(){
		Emp emp = empDao.findById2(3739);
		System.out.println(emp +","+ emp.getDept());
	}
	
}
