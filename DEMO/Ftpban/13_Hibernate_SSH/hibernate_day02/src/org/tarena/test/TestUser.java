package org.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.tarena.entity.NoteBook;
import org.tarena.entity.User;
import org.tarena.util.HibernateUtil;

public class TestUser {
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		
		User user = (User)session.load(
			User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user.getName());
		//ͨ��get�������ʹ�������
		for(NoteBook book : user.getBooks()){
			System.out.println(book.getName());
		}
		session.close();
	}
	
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		
		User user = (User)session.load(
			User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user.getClass().getName());
		
		System.out.println("==================");
		System.out.println(user.getName());
		System.out.println(user.getDescr());
		session.close();
	}
	
	
	@Test
	public void test5(){
		String hql = "select count(id) from User";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		Long size = (Long)query.uniqueResult();
		System.out.println("�ܼ�¼������"+size);
		session.close();
	}
	
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		String hql = "from User";//�ȼ���select * from cn_user
		//query����ִ��hql��
		Query query = session.createQuery(hql);
		//���÷�ҳ����
		query.setFirstResult(0);//�ӵڼ�����ʼץ
		query.setMaxResults(5);//���ץȡ������
		//ִ�в�ѯ
		List<User> list = query.list();
		for(User user:list){
			System.out.println(user.getName());
		}
		session.close();
	}
	
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		String hql = "from User where name=?";
		Query query = session.createQuery(hql);
		//����?����ֵ
		query.setString(0, "demo");
		//ִ�У��鵥��
		User user = (User)query.uniqueResult();
		if(user != null){
			System.out.println(user.getPassword());
		}
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		String hql = "from User";//�ȼ���select * from cn_user
		//query����ִ��hql��
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for(User user:list){
			System.out.println(user.getName()+" "+user.getPassword());
		}
		session.close();
	}
	

	@Test//�������
	public void test1(){
		Session session = 
			HibernateUtil.getSession();
		User user = new User();
		user.setName("hibernate");
		user.setPassword("123456");
		user.setDescr("");
		user.setToken("");
//		user.setId("");//����hibernate�Զ�����
		Transaction tx = 
			session.beginTransaction();
		session.save(user);
		System.out.println(user.getId());
		tx.commit();
		session.close();
	}
	
}
