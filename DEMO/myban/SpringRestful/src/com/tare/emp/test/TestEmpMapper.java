package com.tare.emp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.emp.dao.EmpMapper;
import com.tare.emp.entity.Emp;

/**
 * 测试EmpMapper
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
		emp.setEname("刘备");
		emp.setJob("皇叔");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empMapper.save(emp);
        
        Integer.valueOf("abc");//模拟出异常。	但是此处是使用EmpMapper映射器，没有加上事务注解，因此没有进行事务控制。
        
		// 插入第二个员工
        Emp e2 = new Emp();
        e2.setEname("关羽");
        e2.setJob("候");
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
