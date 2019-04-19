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
 * 测试练习
 * 分页查询	多表联合查询		其他查询：SQL查询		criteria查询	[标准]
 * @author Administrator
 *
 */
public class TestHQL2 {

	@Test
	public void test(){
		String hql = "from Account order by account_id"; 
		int page = 2;//第几页
		int pageSize = 5;//每页容量
		int from = (page - 1) * pageSize;//要查询当页的起点
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(from);//设置起点
		query.setMaxResults(pageSize);//每页容量
		List<Account> accounts = query.list();
		for(Account account : accounts){
			System.out.println(account.getId() +","+ account.getLoginName() +","+ account.getLoginPassword() + account.getServices());
		}
		HibernateUtil.close();
	}
	@Test
	public void test2(){
		String hql2 = "select count(*) from Account";
		int pageSize = 6;//每页容量
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql2);
		int rows = Integer.parseInt(query.uniqueResult().toString());
		int totalPages = 0;//总页数
		if( rows % pageSize == 0){
			totalPages = rows / pageSize;
		} else {
			totalPages = rows / pageSize + 1;
		}
		System.out.println("一共有"+ rows +"条记录，当每页显示"+ pageSize +"条记录时，总共有"+ totalPages +"页记录!");
		HibernateUtil.close();
	}
	/*
	 * 多表联合查询
	 * 1.对象方式关联，2.Join方式关联，3.select子句方式关联
	 */
	@Test
	public void test3(){//对象方式关联
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
	public void test4(){//join方式关联
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
	public void test5(){//select子句关联
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
		String sql = "select * from service where unix_host = ?";//直接使用SQL查询，使用的是表名和字段名，而不是类名和属性名。
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
