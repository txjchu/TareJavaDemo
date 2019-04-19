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
 * ��ϰʹ��Hibernate�����ݿ����ɾ�Ĳ�
 * @author Administrator
 *
 */
public class TestEmp {
	
	@Test
	public void testAdd(){
		Emp e = new Emp();
		e.setId(1);
		e.setName("����");
		e.setAge(18);
		e.setSalary(2888.99);
		e.setMarry(true);
		e.setBirthday(Date.valueOf("1991-01-01"));
		e.setLast_login_time(new java.sql.Timestamp(System.currentTimeMillis()));
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//�����������
		Transaction ts = session.beginTransaction();
		try {
			session.save(e);//�������
			ts.commit();//�ύ����
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();//�ع�����
		} finally {
			session.close();//�ر�session�����ر�JDBC������ʹ�õĸ��ֶ�������ӡ�
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
		emp.setName("����");
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
			ts = session.beginTransaction();//��������
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
