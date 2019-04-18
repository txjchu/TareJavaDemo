package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.tarena.entity.Emp;
import org.tarena.util.HibernateUtil;

public class TestEmp {
	@Test//���Ը���
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//�����ֶθ���,�Ȳ�һ��,Ȼ���޸��ֶ�ֵ
		Emp emp = (Emp)session.get(Emp.class, 5);
		emp.setName("ZhangSan");
		session.update(emp);//����idֵ��emp״̬���µ�db
		tx.commit();
		session.close();
	}
	
	@Test//���԰�������ѯ
	public void test3(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp)session.get(Emp.class, 5);//��id��ѯ
		if(emp != null){
			System.out.println(emp.getName());
		}else{
			System.out.println("û�м�¼");
		}
		session.close();
	}
	
	@Test//����ɾ��
	public void test2(){
		Session session = HibernateUtil.getSession();
		Emp emp = new Emp();
		emp.setNo(8);
		Transaction tx = session.beginTransaction();
		session.delete(emp);//������idɾ��
		tx.commit();
		session.close();
	}
	
	@Test//�������
	public void test1(){
		Session session = HibernateUtil.getSession();
		Emp emp = new Emp();
		emp.setNo(8);
		emp.setName("jack");
		Transaction tx = session.beginTransaction();
		session.save(emp);//��Ӳ���
		tx.commit();//��ɾ����Ҫ�ύ����
		session.close();
	}
	
}
