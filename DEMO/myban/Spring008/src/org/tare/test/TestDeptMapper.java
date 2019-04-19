package org.tare.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.dao.DeptMapper;
import org.tare.entity.Dept;

/**
 * ����DeptMapper
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
	public void testSave(){		//��spring��������󣬲���Ҫ����������ύ�Ϳ��Բ����־�Ч����
		Dept dept = new Dept();
		dept.setDeptno(16);
		dept.setDname("�г���");
		dept.setLoc("������");
		int i = mapper.save(dept);
		System.out.println(i);
		
	}
	@Test
	public void testUpdate(){
		Dept dept = mapper.findById(60);
		dept.setDname("���۲�");
		System.out.println(mapper.update(dept));
	}
	@Test
	public void testDelete(){
		Dept dept = mapper.findById(61);//����
		mapper.delete(dept.getDeptno());
	}
}
