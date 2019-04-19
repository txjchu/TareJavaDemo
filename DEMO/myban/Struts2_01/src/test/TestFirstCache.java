package test;

import netctoss.util.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * 测试一级缓存
 * @author Administrator
 *
 */
public class TestFirstCache {

	/*
	 * 测试一级缓存是否存在，用一个session去查询同一个数据，看查询了几次数据库。
	 * 即查看自动生成的sql语句执行了几次，每执行一次sql语句就会访问一次数据库。
	 */
	@Test
	public void testFirstCache(){//第二次没有再次执行sql，而是直接从一级缓存中获取了查询结果。
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println(emp);
		System.out.println("---------");
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println(emp2);
		session.close();
	}
	@Test
	public void testFirstCache2(){//执行了2次sql语句，因为是不同的session对象。即每个session的一级缓存都是独享的。
		Session session1 = HibernateUtil.getSession();
		Emp emp = (Emp) session1.get(Emp.class, 3739);
		System.out.println("第一个session查询的结果："+ emp);
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 3739);
		System.out.println("第二个session查询的结果："+ emp2);
	}
	/*
	 * 管理一级缓存：
	 * 使用session.evict(obj)方法从一级缓存中移除一个对象。
	 * 使用session.clean()方法清空一级缓存。
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println("查询到了Emp:"+ emp);
		session.evict(emp);//调用session.evict(obj)方法将一个对象从session一级缓存中移除。
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println("再次查询Emp:"+ emp2);
	}
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println("查询到了Emp:"+ emp);
		session.clear();//清空一级缓存
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println("再次查询到Emp:"+ emp2);
	}
	
}
