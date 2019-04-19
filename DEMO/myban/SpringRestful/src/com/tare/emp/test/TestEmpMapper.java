package com.tare.emp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.emp.dao.EmpMapper;
import com.tare.emp.entity.Emp;

/**
 * ����EmpMapper
 * @author Administrator
 *
 */
public class TestEmpMapper {

	private EmpMapper empMapper;			// qualify
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		empMapper = ac.getBean("empMapper", EmpMapper.class);
	}
	@Test
	public void testFindAll(){
		List<Emp> emps = empMapper.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void testFindById(){
		Emp emp = empMapper.findById(12);
		System.out.println(emp);
	}
	@Test
	public void testSave(){
		Emp emp = new Emp();
		emp.setEname("����");
		emp.setJob("����");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empMapper.save(emp);
        
        Integer.valueOf("abc");//ģ����쳣��	���Ǵ˴���ʹ��EmpMapperӳ������û�м�������ע�⣬���û�н���������ơ�
        
		// ����ڶ���Ա��
        Emp e2 = new Emp();
        e2.setEname("����");
        e2.setJob("��");
        e2.setSal(1000.0);
        e2.setEmpno(10);
        empMapper.save(e2);
        
	}
	@Test
	public void testUpdate(){
		Emp emp = empMapper.findById(133);
		emp.setSal(2222.22);
		emp.setComm(22.22);
		empMapper.update(emp);
		System.out.println(empMapper.findById(133));
	}
	@Test
	public void testDelete(){
		empMapper.delete(149);
	}
}
