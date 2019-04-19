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
 * ����DAO
 * @author Administrator
 *
 */
public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmpDAO dao = ac.getBean("jdbcEmpDAO", JdbcEmpDAO.class );//����newһ�����󣬱���������л�ȡ����ȡ����bean����ᱻ����ע��bean�����������������У����ܸ�dao������ע���Ա���ԡ�
	
	@Test
	public void testFindAll(){
		List<Emp> emps = dao.findAll();
		for(Emp e : emps){
			System.out.println(e.getEname() +","+ e.getEmpno() +","+ e.getJob());
		}
	}
	@Test
	public void testFindById(){
		Emp emp = dao.findById(3723);//����ѯ�Ľ��Ϊ�գ�����׳��ս���쳣��EmptyResultDataAccessException
		System.out.println(emp.getEmpno() +","+ emp.getEname() +","+ emp.getJob());
	}
	@Test
	public void testSave(){
		Emp e = new Emp();
        e.setEname("�����");
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
		e.setEname("��ɮ");
		dao.update(e);
	}
	@Test
	public void testDelete(){
		dao.delete(3723);
	}
}
