package test;

import java.util.Iterator;
import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * �����ӳټ��أ�
 * session.load()����ʹ�����ӳټ��ء�load����
 * query.iterate()����ʹ�����ӳټ��ء�iterate����
 * @author Administrator
 *
 */
public class TestLazy {

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		//��ѯ�����ݿ⣬����ֻ��ȡ��ID
		Emp emp = (Emp) session.load(Emp.class, 3744);
		System.out.println("----��ѯ������-----");
		System.out.println("���ڲ�ȥ�������ݿ��𣿣�"+ emp);
		session.close();
	}
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		String hql = "from Emp"; 
		Query query = session.createQuery(hql);
		//���������ݿ⣬����ֻ��ѯ��ID��
		Iterator<Emp> emps = query.iterate();
		System.out.println("ִ����iterate����--------");
		System.out.println("��ʼ����emps:");
		while(emps.hasNext()){
			//ÿһ�η��ʵ���������һ��Ԫ��ʱ����ѯһ�����ݿ⡣
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
		System.out.println("��ѯ�����ݿ�-----");
		System.out.println("�������ݿ⣺");
		for(Emp e : emps ){
			System.out.println(e);
		}
	}
}
