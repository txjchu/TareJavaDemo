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
 * 测试DeptDao类
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	@Test	//测试按给定部门编号查询dept表中的所有记录
	public void testFindByDeptno(){
		Integer deptno = 15;
		Dept dept = null;
		DeptDao dd = new DeptDao();
		dept = dd.findByDeptno(deptno);
		System.out.println(dept);
	}
	
	@Test	//测试查询数据库中dept表中所有记录的方法
	public void testFindAll(){
		DeptDao dd = new DeptDao();
		List<Dept> depts = dd.findAll();
		for(Dept dept : depts){
			System.out.println(dept);
		}
	}
	
	@Test	//测试向数据库dept表中增加数据的方法
	public void testAdd(){
		Integer deptno = 15;
		String dname = "市场部";
		String loc = "武汉";
		Dept dept = new Dept(deptno, dname, loc);
		DeptDao dd = new DeptDao();
		System.out.println(dd.add(dept));
	}
	
	@Test	//测试向数据库dept表中修改数据的方法
	public void testUpdate(){
		String dname = "广告部";
		String loc = "南京";
		Integer deptno = 15;
		Dept dept = new Dept(deptno, dname, loc);
		DeptDao dd = new DeptDao();
		System.out.println(dd.update(dept));
	}
}
