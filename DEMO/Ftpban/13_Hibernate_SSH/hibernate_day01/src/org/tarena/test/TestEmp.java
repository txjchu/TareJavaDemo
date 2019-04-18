package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.tarena.entity.Emp;
import org.tarena.util.HibernateUtil;

public class TestEmp {
	@Test//测试更新
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//部分字段更新,先查一下,然后修改字段值
		Emp emp = (Emp)session.get(Emp.class, 5);
		emp.setName("ZhangSan");
		session.update(emp);//根据id值将emp状态更新到db
		tx.commit();
		session.close();
	}
	
	@Test//测试按主键查询
	public void test3(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp)session.get(Emp.class, 5);//按id查询
		if(emp != null){
			System.out.println(emp.getName());
		}else{
			System.out.println("没有记录");
		}
		session.close();
	}
	
	@Test//测试删除
	public void test2(){
		Session session = HibernateUtil.getSession();
		Emp emp = new Emp();
		emp.setNo(8);
		Transaction tx = session.beginTransaction();
		session.delete(emp);//按对象id删除
		tx.commit();
		session.close();
	}
	
	@Test//测试添加
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
