package test;

import java.util.Arrays;
import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import entity.Service;

/**
 * ������ϰ
 * ��ҳ��ѯ	������ϲ�ѯ		������ѯ��SQL��ѯ		criteria��ѯ	[��׼]
 * @author Administrator
 *
 */
public class TestHQL2 {

	@Test
	public void test(){
		String hql = "from Account order by account_id"; 
		int page = 2;//�ڼ�ҳ
		int pageSize = 5;//ÿҳ����
		int from = (page - 1) * pageSize;//Ҫ��ѯ��ҳ�����
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(from);//�������
		query.setMaxResults(pageSize);//ÿҳ����
		List<Account> accounts = query.list();
		for(Account account : accounts){
			System.out.println(account.getId() +","+ account.getLoginName() +","+ account.getLoginPassword() + account.getServices());
		}
		HibernateUtil.close();
	}
	@Test
	public void test2(){
		String hql2 = "select count(*) from Account";
		int pageSize = 6;//ÿҳ����
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql2);
		int rows = Integer.parseInt(query.uniqueResult().toString());
		int totalPages = 0;//��ҳ��
		if( rows % pageSize == 0){
			totalPages = rows / pageSize;
		} else {
			totalPages = rows / pageSize + 1;
		}
		System.out.println("һ����"+ rows +"����¼����ÿҳ��ʾ"+ pageSize +"����¼ʱ���ܹ���"+ totalPages +"ҳ��¼!");
		HibernateUtil.close();
	}
	/*
	 * ������ϲ�ѯ
	 * 1.����ʽ������2.Join��ʽ������3.select�Ӿ䷽ʽ����
	 */
	@Test
	public void test3(){//����ʽ����
		String hql = "select s.service_id, s.unix_host, s.os_username, s.login_passwd, a.id, a.email, a.qq from Service s, Account a where s.account.id = a.id";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] s : list){
			System.out.println(Arrays.toString(s));
		}
		HibernateUtil.close();
	}
	@Test
	public void test4(){//join��ʽ����
		String hql = "select s.service_id,s.unix_host, s.os_username, s.login_passwd, a.id, a.email, a.qq from Service s join s.account a";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] s : list){
			System.out.println(Arrays.toString(s));
		}
		HibernateUtil.close();
	}
	@Test
	public void test5(){//select�Ӿ����
		String hql = "select s.service_id,s.unix_host, s.os_username, s.login_passwd, account.id, account.email, account.qq from Service s ";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] s : list){
			System.out.println(Arrays.toString(s));
		}
		HibernateUtil.close();
	}
	@Test
	public void test6(){
		String sql = "select * from service where unix_host = ?";//ֱ��ʹ��SQL��ѯ��ʹ�õ��Ǳ������ֶ�������������������������
		Session session = HibernateUtil.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0, "192.168.0.20");
		query.addEntity(Service.class);
		List<Service> services = query.list();
		for(Service s : services){
			System.out.println(s);
		}
		HibernateUtil.close();
	}
}
