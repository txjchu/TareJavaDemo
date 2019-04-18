package org.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.tarena.entity.User;
import org.tarena.util.HibernateUtil;

public class TestCache {
	@Test
	public void test3(){
		findAll();
		System.out.println("==============");
		findAll();
	}
	
	public void findAll(){
		Session session = HibernateUtil.getSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		//采用查询缓存
		query.setCacheable(true);
		List<User> list = query.list();
		for(User user:list){
			System.out.println(user.getName());
		}
		session.close();
	}
	

	@Test
	public void test2(){
		Session session = 
			HibernateUtil.getSession();
		//第一次查询,查DB,返回结果放入一级缓存
		User user = (User)session.get(
			User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user.getName());
		session.close();
		//第二次查询,从缓存取出user对象
		Session session1 = 
			HibernateUtil.getSession();
		User user1 = (User)session1.get(
				User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user1.getPassword());
		System.out.println(user==user1);
		session1.close();
	}
	
	@Test
	public void test1(){
		Session session = 
			HibernateUtil.getSession();
		//第一次查询,查DB,返回结果放入一级缓存
		User user = (User)session.get(
			User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user.getName());
		//第二次查询,从缓存取出user对象
		User user1 = (User)session.get(
				User.class, "ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		System.out.println(user1.getPassword());
		System.out.println(user==user1);
		session.close();
	}
	
}
