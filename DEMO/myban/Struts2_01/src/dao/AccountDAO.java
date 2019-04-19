package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import netctoss.util.HibernateUtil;

import entity.Account;

/**
 * 数据表Account对应的DAO
 * @author Administrator
 *
 */
public class AccountDAO {

	public List<Account> findAll(){
		Session session = HibernateUtil.getSession();
		String hql = "from Account";
		Query query = session.createQuery(hql);	
		List<Account> accounts = query.list();//没有使用延迟加载的方法
//		HibernateUtil.close();
		return accounts;
	}
	public Account findById(Integer id){
		Session session = HibernateUtil.getSession();
		Account account = (Account) session.get(Account.class, id);//非延迟加载方法，但是关联属性的获取是延迟加载的。
//		session.close();
		return account;
	}
	public List<Account> findByName(String loginName){
		Session session = HibernateUtil.getSession();
		String hql = "from Account where loginName = ?";	// where条件语句中对比的是属性名，而不能写字段名。
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
			System.out.println("进入了AccountDAO中的update方法异常了！");
			e.printStackTrace();
			ts.rollback();
		}
		//所有的方法操作完成后，不自己关闭session,统一交给AOP或者过滤器来关闭。在一个Action业务中以防止延迟加载造成数据获取中断。
//		finally {
//			HibernateUtil.close();
//		}
	}
	
	//删除
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
