package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import netctoss.util.HibernateUtil;

import entity.Account;

/**
 * ���ݱ�Account��Ӧ��DAO
 * @author Administrator
 *
 */
public class AccountDAO {

	public List<Account> findAll(){
		Session session = HibernateUtil.getSession();
		String hql = "from Account";
		Query query = session.createQuery(hql);	
		List<Account> accounts = query.list();//û��ʹ���ӳټ��صķ���
//		HibernateUtil.close();
		return accounts;
	}
	public Account findById(Integer id){
		Session session = HibernateUtil.getSession();
		Account account = (Account) session.get(Account.class, id);//���ӳټ��ط��������ǹ������ԵĻ�ȡ���ӳټ��صġ�
//		session.close();
		return account;
	}
	public List<Account> findByName(String loginName){
		Session session = HibernateUtil.getSession();
		String hql = "from Account where loginName = ?";	// where��������жԱȵ�����������������д�ֶ�����
		Query query = session.createQuery(hql);
		query.setString(0, loginName);
		List<Account> accounts = null;
		accounts = query.list(); 
//		while(query.list().iterator().hasNext()){
//			account = (Account) query.list().iterator().next();
//		}
		return accounts;		
	}
	public void save(Account account){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.save(account);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
//		HibernateUtil.close();
	}
	public void update(Account account){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(account);
			ts.commit();
		} catch (Exception e) {
			System.out.println("������AccountDAO�е�update�����쳣�ˣ�");
			e.printStackTrace();
			ts.rollback();
		}
		//���еķ���������ɺ󣬲��Լ��ر�session,ͳһ����AOP���߹��������رա���һ��Actionҵ�����Է�ֹ�ӳټ���������ݻ�ȡ�жϡ�
//		finally {
//			HibernateUtil.close();
//		}
	}
	
	//ɾ��
	public void delete(Account account){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(account);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
	}
	
	
}
