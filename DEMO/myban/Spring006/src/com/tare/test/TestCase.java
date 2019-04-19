package com.tare.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.dao.EmpDAO;
import com.tare.dao.JdbcEmpDAO;
import com.tare.entity.Emp;

/**
 * 测试DAO
 * @author Administrator
 *
 */
public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmpDAO dao = ac.getBean("jdbcEmpDAO", JdbcEmpDAO.class );//不能new一个对象，必须从容器中获取，获取到的bean对象会被依赖注入bean。否则，容器不能运行，不能给dao对象中注入成员属性。
	
	@Test
	public void testFindAll(){
		List<Emp> emps = dao.findAll();
		for(Emp e : emps){
			System.out.println(e.getEname() +","+ e.getEmpno() +","+ e.getJob());
		}
	}
	@Test
	public void testFindById(){
		Emp emp = dao.findById(3723);//若查询的结果为空，则会抛出空结果异常。EmptyResultDataAccessException
		System.out.println(emp.getEmpno() +","+ emp.getEname() +","+ emp.getJob());
	}
	@Test
	public void testSave(){
		Emp e = new Emp();
        e.setEname("孙悟空");
        e.setJob("SALESMAN");
        e.setMgr(3);
        e.setHiredate(new Date(System.currentTimeMillis()));
        e.setSal(3000.0);
        e.setDeptno(30);
        dao.save(e);
	}
	@Test
	public void testUpdate(){
		Emp e = dao.findById(3723);
		e.setEname("唐僧");
		dao.update(e);
	}
	@Test
	public void testDelete(){
		dao.delete(3723);
	}
}
