package test;

import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * 测试二级缓存
 * @author Administrator
 *
 */
public class testSecondCache {

	@Test
	public void test(){
		Session session = HibernateUtil.getSession();
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		List<Emp> emps = query.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		HibernateUtil.close();
	}
	@Test
	public void test1(){
		Session session1 = HibernateUtil.getSession();
		Emp emp1 = (Emp) session1.get(Emp.class, 153);
		System.out.println("emp1:"+ emp1);
		System.out.println("测试二级缓存，所有session共享二级缓存中的数据-----------------");
		HibernateUtil.close();
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 153);//此次查询没有使用sql语句去数据库中查询，直接从缓存中取出数据显示。
		System.out.println("emp2:"+ emp2);
		HibernateUtil.close();
	}
	@Test
	public void test2(){
		Session session1 = HibernateUtil.getSession();
		Emp emp1 = (Emp) session1.get(Emp.class, 153);
		System.out.println("emp1:"+ emp1);
		System.out.println("测试二级缓存，所有session共享二级缓存中的数据-----------------");
		HibernateUtil.close();
		System.out.println("此次，在第二个session之前，清空二级缓存，观察第二次查询情况------------");
		HibernateUtil.getSessionFactory().evict(Emp.class);//清空二级缓存中的所有Emp类型的对象。
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 153);//此次查询再次使用了sql语句去数据库中查询。
		System.out.println("emp2:"+ emp2);
		HibernateUtil.close();
	}
	@Test
	public void test3(){
		String hql = "from Emp";
		Session session1 = HibernateUtil.getSession();
		Query query = session1.createQuery(hql);
		query.setCacheable(true);//开启查询缓存
		List<Emp> emps = query.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
		System.out.println("测试查询缓存，查询缓存是特殊的二级缓存。-----------------");
		HibernateUtil.close();
//		System.out.println("此次，在第二个session之前，清空二级缓存，观察第二次查询情况------------");
//		HibernateUtil.getSessionFactory().evict(Emp.class);//清空二级缓存中的所有Emp类型的对象。
		
		hql = "from Emp";
		Session session2 = HibernateUtil.getSession();
		Query query2 = session2.createQuery(hql);//再创建一个不同的Query对象
		query2.setCacheable(true);//开启查询缓存。。。。
		emps = query2.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
		HibernateUtil.close();
	
	}
	@Test
	public void test4(){
		String hql = "from Emp";
		Session session1 = HibernateUtil.getSession();
		Query query = session1.createQuery(hql);
		query.setCacheable(true);//开启查询缓存
		List<Emp> emps = query.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
		System.out.println("测试查询缓存，查询缓存是特殊的二级缓存。-----------------");
		HibernateUtil.close();
		System.out.println("此次，在第二个session之前，清空二级缓存，观察第二次查询情况------------");
		HibernateUtil.getSessionFactory().evict(Emp.class);//清空二级缓存中的所有Emp类型的对象。
		
		hql = "from Emp";
		Session session2 = HibernateUtil.getSession();
		Query query2 = session2.createQuery(hql);//再创建一个不同的Query对象
		query2.setCacheable(true);//开启查询缓存。。。。
		emps = query2.list();	//此次会多次查询数据库，findById(id)....???
		for(Emp emp : emps){
			System.out.println(emp);
		}
		HibernateUtil.close();	
	}

}
