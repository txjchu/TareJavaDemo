package org.tare.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.dao.DeptMapper;
import org.tare.entity.Dept;

/**
 * 测试DeptMapper
 * @author Administrator
 *
 */
public class TestDeptMapper {
	DeptMapper mapper = null;
	@Before
	public void testBefore(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		mapper = ac.getBean("deptMapper", DeptMapper.class);
		System.out.println(mapper.getClass());
	}
	@Test
	public void testFindAll(){
		List<Dept> list = mapper.findAll();
		for(Dept d : list){
			System.out.println(d);
		}
	}
	/*
	 *	resultType="int"
	 *	resultType="int" 
	 */
	@Test
	public void testFindById(){
		Dept dept = mapper.findById(15);
		System.out.println(dept);
	}
	@Test
	public void testSave(){		//被spring容器管理后，不需要操作后进行提交就可以产生持久效果。
		Dept dept = new Dept();
		dept.setDeptno(16);
		dept.setDname("市场部");
		dept.setLoc("高新区");
		int i = mapper.save(dept);
		System.out.println(i);
		
	}
	@Test
	public void testUpdate(){
		Dept dept = mapper.findById(60);
		dept.setDname("销售部");
		System.out.println(mapper.update(dept));
	}
	@Test
	public void testDelete(){
		Dept dept = mapper.findById(61);//多余
		mapper.delete(dept.getDeptno());
	}
}
