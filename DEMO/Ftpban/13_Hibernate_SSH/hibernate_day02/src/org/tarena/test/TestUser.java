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
		//通过get方法访问关联数据
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
		System.out.println("总记录数量："+size);
		session.close();
	}
	
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		String hql = "from User";//等价于select * from cn_user
		//query用于执行hql的
		Query query = session.createQuery(hql);
		//设置分页参数
		query.setFirstResult(0);//从第几条开始抓
		query.setMaxResults(5);//最大抓取多少条
		//执行查询
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
		//设置?参数值
		query.setString(0, "demo");
		//执行，查单行
		User user = (User)query.uniqueResult();
		if(user != null){
			System.out.println(user.getPassword());
		}
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		String hql = "from User";//等价于select * from cn_user
		//query用于执行hql的
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for(User user:list){
			System.out.println(user.getName()+" "+user.getPassword());
		}
		session.close();
	}
	

	@Test//测试添加
	public void test1(){
		Session session = 
			HibernateUtil.getSession();
		User user = new User();
		user.setName("hibernate");
		user.setPassword("123456");
		user.setDescr("");
		user.setToken("");
//		user.setId("");//利用hibernate自动生成
		Transaction tx = 
			session.beginTransaction();
		session.save(user);
		System.out.println(user.getId());
		tx.commit();
		session.close();
	}
	
}
