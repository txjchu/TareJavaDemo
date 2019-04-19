package com.tare.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import com.tare.entity.Emp;
import com.tare.util.HibernateUtil;

/**
 * 练习使用Hibernate对数据库的增删改查
 * @author Administrator
 *
 */
public class TestEmp {
	
	@Test
	public void testAdd(){
		Emp e = new Emp();
		e.setId(1);
		e.setName("呱呱");
		e.setAge(18);
		e.setSalary(2888.99);
		e.setMarry(true);
		e.setBirthday(Date.valueOf("1991-01-01"));
		e.setLast_login_time(new java.sql.Timestamp(System.currentTimeMillis()));
		//获取session
		Session session = HibernateUtil.getSession();
		//开启事务管理
		Transaction ts = session.beginTransaction();
		try {
			session.save(e);//保存对象
			ts.commit();//提交事务
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();//回滚事务
		} finally {
			session.close();//关闭session，即关闭JDBC工作中使用的各种对象和连接。
		}
	}
	
	@Test
	public void testFindAll(){
		List<Emp> emps = new ArrayList<Emp>();
		Session session = HibernateUtil.getSession();
		String sql = "from Emp";
		Query query = session.createQuery(sql);
		emps = query.list();
		for(Emp e : emps){
			System.out.println(e);
		}
		session.close();
	}
	@Test
	public void testFindById(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 168);
		System.out.println(emp);
		session.close();
	}
	@Test
	public void testUpdate(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 164);
		emp.setName("喵喵");
		emp.setAge(12);
		emp.setSalary(888.88);
		emp.setLast_login_time(new Timestamp(System.currentTimeMillis()));
		Transaction ts = session.beginTransaction();
		
		try {
			session.update(emp);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}
	@Test
	public void testDelete(){
		Session session = HibernateUtil.getSession();
		Transaction ts = null;
		try {
			Emp emp = (Emp) session.get(Emp.class, 168);
			ts = session.beginTransaction();//开启事务
			session.delete(emp);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}
}
