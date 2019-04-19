package com.tare.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.tare.dao.DeptDao;
import com.tare.entity.Dept;
import com.tare.util.JdbcUtil;

/**
 * ����DeptDao��
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	@Test	//���԰��������ű�Ų�ѯdept���е����м�¼
	public void testFindByDeptno(){
		Integer deptno = 15;
		Dept dept = null;
		DeptDao dd = new DeptDao();
		dept = dd.findByDeptno(deptno);
		System.out.println(dept);
	}
	
	@Test	//���Բ�ѯ���ݿ���dept�������м�¼�ķ���
	public void testFindAll(){
		DeptDao dd = new DeptDao();
		List<Dept> depts = dd.findAll();
		for(Dept dept : depts){
			System.out.println(dept);
		}
	}
	
	@Test	//���������ݿ�dept�����������ݵķ���
	public void testAdd(){
		Integer deptno = 15;
		String dname = "�г���";
		String loc = "�人";
		Dept dept = new Dept(deptno, dname, loc);
		DeptDao dd = new DeptDao();
		System.out.println(dd.add(dept));
	}
	
	@Test	//���������ݿ�dept�����޸����ݵķ���
	public void testUpdate(){
		String dname = "��沿";
		String loc = "�Ͼ�";
		Integer deptno = 15;
		Dept dept = new Dept(deptno, dname, loc);
		DeptDao dd = new DeptDao();
		System.out.println(dd.update(dept));
	}
}
