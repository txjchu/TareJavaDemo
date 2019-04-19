package com.tare.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tare.dao.EmpMapper;
import com.tare.entity.Emp;
import com.tare.util.MyBatisUtil;

/**
 * ������
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
		emp.setName("֩�뾫");
		emp.setAge(100);
		emp.setSalary(1000.3);
		System.out.println(emp);//ԭid��emp
		dao.save(emp);
		session.commit();
		/*
		 * ע�⣺���Ĳ�ִ�к�������ύ����������SQL������Ч��
		 */
		System.out.println(dao.findByName(emp.getName()));//�����ʹ�������е�id��emp
		session.close();
	}
	@Test
	public void testUpdete(){
		Emp emp = dao.findById(18);
		emp.setName("����");
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
