package test;

import netctoss.util.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * ����һ������
 * @author Administrator
 *
 */
public class TestFirstCache {

	/*
	 * ����һ�������Ƿ���ڣ���һ��sessionȥ��ѯͬһ�����ݣ�����ѯ�˼������ݿ⡣
	 * ���鿴�Զ����ɵ�sql���ִ���˼��Σ�ÿִ��һ��sql���ͻ����һ�����ݿ⡣
	 */
	@Test
	public void testFirstCache(){//�ڶ���û���ٴ�ִ��sql������ֱ�Ӵ�һ�������л�ȡ�˲�ѯ�����
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println(emp);
		System.out.println("---------");
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println(emp2);
		session.close();
	}
	@Test
	public void testFirstCache2(){//ִ����2��sql��䣬��Ϊ�ǲ�ͬ��session���󡣼�ÿ��session��һ�����涼�Ƕ���ġ�
		Session session1 = HibernateUtil.getSession();
		Emp emp = (Emp) session1.get(Emp.class, 3739);
		System.out.println("��һ��session��ѯ�Ľ����"+ emp);
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 3739);
		System.out.println("�ڶ���session��ѯ�Ľ����"+ emp2);
	}
	/*
	 * ����һ�����棺
	 * ʹ��session.evict(obj)������һ���������Ƴ�һ������
	 * ʹ��session.clean()�������һ�����档
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println("��ѯ����Emp:"+ emp);
		session.evict(emp);//����session.evict(obj)������һ�������sessionһ���������Ƴ���
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println("�ٴβ�ѯEmp:"+ emp2);
	}
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, 3739);
		System.out.println("��ѯ����Emp:"+ emp);
		session.clear();//���һ������
		Emp emp2 = (Emp) session.get(Emp.class, 3739);
		System.out.println("�ٴβ�ѯ��Emp:"+ emp2);
	}
	
}
