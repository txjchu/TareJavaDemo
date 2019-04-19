package com.tare.empmgr.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.empmgr.dao.EmpMapper;
import com.tare.empmgr.entity.Condition;
import com.tare.empmgr.entity.Emp;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestEmpMapper {
	
	EmpMapper mapper = null;

	@Before
	public void beforeAll(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		mapper = ac.getBean("empMapper", EmpMapper.class);
	}
	
	@Test
	public void testFindAll(){
		List<Emp> emps = mapper.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void testFindByDept(){
		Condition con = new Condition();
		con.setDeptno(10);
		List<Emp> emps = mapper.findByDept(con);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void testFindBySal(){
		Condition con = new Condition();
		con.setSal(4000.0);
		List<Emp> emps = mapper.findBySal(con);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void testFindByCondition(){
		Condition con = new Condition();
		con.setDeptno(10);
		con.setSal(3000.0);
		List<Emp> emps = mapper.findByDeptAndSal(con);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void update(){
		Emp emp = new Emp();
		emp.setEmpno(12);
		emp.setEname("JAM");
		emp.setSal(3300.0);
		mapper.update(emp);
	}
	@Test
	public void findById(){
		Emp emp = mapper.findById(12);
		System.out.println(emp);
	}
	@Test
	public void testFindByCondition2(){
		Condition con = new Condition();
		con.setDeptno(10);
		con.setSal(2500.0);
		List<Emp> emps = mapper.findByCondition(con);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test 
	public void testUpdate2(){
		Emp emp = mapper.findById(3726);
		emp.setSal(6666.666);
		mapper.update2(emp);
		System.out.println(mapper.findById(3726));
	}
	@Test
	public void testFindByEmpnos(){		// Available 有效的可得的可利用的
		List<Integer> empnos = new ArrayList<Integer>();
		empnos.add(2);
		empnos.add(3);
		empnos.add(4);
		empnos.add(5);
		System.out.println(empnos);
		Condition con = new Condition();
		con.setEmpnos(empnos);
//		List<Emp> emps = mapper.findByEmpnos(empnos);//1.使用封装集合的Condition对象可以成功。2.直接传入集合会出异常
		int[] arr = {2, 3, 4, 5};
		List<Emp> emps = mapper.findByEmpnosObj(arr);	//需将EmpMapper.xml中的该update方法的id值修改为findByEmpnosObj.
		for(Emp e : emps){
			System.out.println(e);
		}
	}
}
