package com.tare.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tare.dao.EmpMapper;
import com.tare.entity.Emp;
import com.tare.util.MyBatisUtil;

/**
 * 测试类
 */
public class TestEmpMapper {

	SqlSession session = MyBatisUtil.getSession();
	EmpMapper dao = session.getMapper(EmpMapper.class);

	@Test
	public void testFindAll(){
		
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
	}
	@Test 
	public void testFindByid(){
		Emp emp = dao.findById(14);
		System.out.println(emp);
	}
	@Test
	public void testSave(){
		Emp emp = new Emp();
		emp.setId(3);
		emp.setName("蜘蛛精");
		emp.setAge(100);
		emp.setSalary(1000.3);
		System.out.println(emp);//原id的emp
		dao.save(emp);
		session.commit();
		/*
		 * 注意：增改查执行后必须有提交操作，否则，SQL操作无效。
		 */
		System.out.println(dao.findByName(emp.getName()));//插入后，使用了序列的id的emp
		session.close();
	}
	@Test
	public void testUpdete(){
		Emp emp = dao.findById(18);
		emp.setName("老鼠精");
		emp.setAge(101);
		System.out.println(emp);
		dao.update(emp);
		session.commit();
		session.close();
	}
	@Test
	public void testDelete(){
		dao.delete(23);
		session.commit();
		session.close();
	}
}
