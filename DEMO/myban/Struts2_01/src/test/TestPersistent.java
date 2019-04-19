package test;

import java.sql.Date;

import netctoss.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Emp;

/**
 * 测试Hibernate中对象的三种状态：
 * 临时态、持久态（Persistent）、游离态
 * @author Administrator
 *
 */
public class TestPersistent {
	
	@Test
	public void test1(){
//		Emp emp = (Emp) session.get(Emp.class, 3739);//通过get、load、list、iterate方法获取到的对象都是持久态的。
//		System.out.println("查询出了Emp:"+ emp);
		Emp emp = new Emp();
		emp.setEmpno(111);
		emp.setEname("牛魔王");
		emp.setJob("山大王");
		emp.setMgr(1);
		emp.setDeptno(10);
		emp.setSal(2222.22);
		emp.setComm(222.22);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//开启session的事务管理
		try {
			session.save(emp);//save方法后，对象从临时态转变为持久态。
			tx.commit();
			session.clear();//清空一下一级缓存，观察没有成功插入记录时，数据库中是否有记录，再次查询时若一级缓存中没有记录能否从数据库中查询到记录。
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("进入了异常分支，没有清空一级缓存");
			tx.rollback();
		} finally {
			Emp emp1 = (Emp) session.get(Emp.class, emp.getEmpno());
			System.out.println("保存后，再次查询emp，观察是否为持久态的对象存在一级缓存中："+ emp1);
			session.close();
		}
	}
	@Test
	public void test3(){
		Emp emp = new Emp();
		emp.setEmpno(111);
		emp.setEname("铁扇公主啊啊啊啊啊啊铁扇公主啊啊啊啊啊啊");// ename最大长度为10，GBK编码一个汉字3个字符。
		emp.setJob("公主");
		emp.setSal(2222.22);
		emp.setComm(222.22);
		emp.setMgr(3744);
		emp.setDeptno(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//开启事务
		try {
			session.save(emp);//没有提交事务时，保存在一级缓存中，处于持久态，此时修改数据后再提交，观察是修改后的数据。
			emp.setEname("红孩儿子啊啊啊啊啊啊红孩儿子啊啊啊啊啊啊");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();//为什么抛了异常还能够插进记录。事务管理怎么不起作用？不，事务起作用了。数据表中没有不符合表结构约束的记录。
			System.out.println("进入了异常分支");
			tx.rollback();
		} finally {
//			session.clear();//清空一级缓存
			session.evict(emp);//从一级缓存中移出对象
			/*
			 * 清空一级缓存后再次查询该对象，观察是否修改成功，依然可以查到该条记录，且并不是从数据表中查到的。
			 * 因为数据表中没有该条记录。那么，处于游离态的该对象被放在了哪里呢？
			 * 处于内存中没有被GC回收？
			 */			
			Emp emp2 = (Emp) session.get(Emp.class, emp.getEmpno());
			System.out.println(emp);
			session.close();
		}
	}
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();//开启事务
		Emp emp = (Emp) session.get(Emp.class, 3744);
		System.out.println(emp);
		emp.setEname("黄风怪");
		session.flush();//只是触发了更新操作，并没有提交事务。所以数据表中的记录并没有改变。
		session.close();
	}
}
