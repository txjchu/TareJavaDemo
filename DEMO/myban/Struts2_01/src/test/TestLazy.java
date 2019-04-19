package test;

import java.util.Iterator;
import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * 测试延迟加载：
 * session.load()方法使用了延迟加载。load方法
 * query.iterate()方法使用了延迟加载。iterate方法
 * @author Administrator
 *
 */
public class TestLazy {

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		//查询了数据库，但是只获取了ID
		Emp emp = (Emp) session.load(Emp.class, 3744);
		System.out.println("----查询了数据-----");
		System.out.println("现在才去访问数据库吗？："+ emp);
		session.close();
	}
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		String hql = "from Emp"; 
		Query query = session.createQuery(hql);
		//访问了数据库，但是只查询了ID列
		Iterator<Emp> emps = query.iterate();
		System.out.println("执行了iterate方法--------");
		System.out.println("开始遍历emps:");
		while(emps.hasNext()){
			//每一次访问迭代器的下一个元素时，查询一次数据库。
			Emp emp = emps.next();
			System.out.println(emp);
		}
		session.close();
	}
	@Test
	public void testList(){
		Session session = HibernateUtil.getSession();
		
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		List<Emp> emps = query.list();
		System.out.println("查询了数据库-----");
		System.out.println("遍历数据库：");
		for(Emp e : emps ){
			System.out.println(e);
		}
	}
}
