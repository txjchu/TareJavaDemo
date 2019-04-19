package org.tare.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.dao.DeptDao;
import org.tare.dao.DeptDaoImpl;
import org.tare.entity.Dept;

/**
 * 测试DeptDaoImpl
 * @author Administrator
 *
 */
public class TestDeptDaoImpl {
	
	private DeptDao dao = null;
	@Before
	public void test(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("deptDaoImpl", DeptDaoImpl.class);
		System.out.println("dao:"+ dao.getClass().getName());
	}
	@Test
	public void testfindAll(){
		List<Dept> list = dao.findAll();
		for(Dept dept : list){
			System.out.println(dept);
		}
	}
	@Test
	public void testFindById(){
		Dept dept = dao.findById(15);
		System.out.println(dept);
	}
	@Test
	public void testSave(){
		Dept dept = new Dept();
		dept.setDeptno(25);
		dept.setDname("营销部");
		dept.setLoc("太原");
		System.out.println(dao.save(dept));
	}
	@Test
	public void testUpdate(){
		Dept dept = dao.findById(70);
		dept.setLoc("北京");
		System.out.println(dao.update(dept));
	}
	@Test
	public void testDelete(){
		dao.delete(70);
	}
}
