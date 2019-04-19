package test;

import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

/**
 * ���Զ�������
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
		System.out.println("���Զ������棬����session������������е�����-----------------");
		HibernateUtil.close();
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 153);//�˴β�ѯû��ʹ��sql���ȥ���ݿ��в�ѯ��ֱ�Ӵӻ�����ȡ��������ʾ��
		System.out.println("emp2:"+ emp2);
		HibernateUtil.close();
	}
	@Test
	public void test2(){
		Session session1 = HibernateUtil.getSession();
		Emp emp1 = (Emp) session1.get(Emp.class, 153);
		System.out.println("emp1:"+ emp1);
		System.out.println("���Զ������棬����session������������е�����-----------------");
		HibernateUtil.close();
		System.out.println("�˴Σ��ڵڶ���session֮ǰ����ն������棬�۲�ڶ��β�ѯ���------------");
		HibernateUtil.getSessionFactory().evict(Emp.class);//��ն��������е�����Emp���͵Ķ���
		Session session2 = HibernateUtil.getSession();
		Emp emp2 = (Emp) session2.get(Emp.class, 153);//�˴β�ѯ�ٴ�ʹ����sql���ȥ���ݿ��в�ѯ��
		System.out.println("emp2:"+ emp2);
		HibernateUtil.close();
	}
	@Test
	public void test3(){
		String hql = "from Emp";
		Session session1 = HibernateUtil.getSession();
		Query query = session1.createQuery(hql);
		query.setCacheable(true);//������ѯ����
		List<Emp> emps = query.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
		System.out.println("���Բ�ѯ���棬��ѯ����������Ķ������档-----------------");
		HibernateUtil.close();
//		System.out.println("�˴Σ��ڵڶ���session֮ǰ����ն������棬�۲�ڶ��β�ѯ���------------");
//		HibernateUtil.getSessionFactory().evict(Emp.class);//��ն��������е�����Emp���͵Ķ���
		
		hql = "from Emp";
		Session session2 = HibernateUtil.getSession();
		Query query2 = session2.createQuery(hql);//�ٴ���һ����ͬ��Query����
		query2.setCacheable(true);//������ѯ���档������
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
		query.setCacheable(true);//������ѯ����
		List<Emp> emps = query.list();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
		System.out.println("���Բ�ѯ���棬��ѯ����������Ķ������档-----------------");
		HibernateUtil.close();
		System.out.println("�˴Σ��ڵڶ���session֮ǰ����ն������棬�۲�ڶ��β�ѯ���------------");
		HibernateUtil.getSessionFactory().evict(Emp.class);//��ն��������е�����Emp���͵Ķ���
		
		hql = "from Emp";
		Session session2 = HibernateUtil.getSession();
		Query query2 = session2.createQuery(hql);//�ٴ���һ����ͬ��Query����
		query2.setCacheable(true);//������ѯ���档������
		emps = query2.list();	//�˴λ��β�ѯ���ݿ⣬findById(id)....???
		for(Emp emp : emps){
			System.out.println(emp);
		}
		HibernateUtil.close();	
	}

}
