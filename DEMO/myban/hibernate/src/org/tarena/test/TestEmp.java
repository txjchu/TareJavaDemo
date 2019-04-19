package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.tarena.entity.Emp;
import org.tarena.util.HibernateUtil;

public class TestEmp {
	
	
	@Test//测试删除
	public void test2(){
		Session session = HibernateUtil.getSession();
		Emp emp = new Emp();
		emp.setNo(8);
		Transaction tx = session.beginTransaction();
		session.delete(emp);
		tx.commit();
		session.close();
	}
	@Test//测试保存
	public void test1(){
		Session session = HibernateUtil.getSession();
		Emp emp = new Emp();
		emp.setNo(8);
		emp.setName("jack");
		Transaction tx = session.beginTransaction();
		session.save(emp);//添加操作
		tx.commit();//增删改需要提交事务
		session.close();
	}
}
