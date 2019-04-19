package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import netctoss.util.HibernateUtil;

import org.junit.Test;

import dao.AccountDAO;
import entity.Account;
import entity.Service;

/**
 * ����AccountDAO
 * @author Administrator
 *
 */
public class TestAccountDAO {

	@Test
	public void testFindAll(){
		AccountDAO dao = new AccountDAO();
		List<Account> accounts = dao.findAll();
		for(Account a : accounts){
			System.out.println(a.getId() +":"+ a.getLoginName() +":"+ a.getLoginPassword());
		}
	}
	
	@Test
	public void testOneToMany(){
		AccountDAO dao = new AccountDAO();
		Account a = dao.findById(2028);
		System.out.println(a.getId() +":"+ a.getLoginName() +":"+ a.getLoginPassword());
		System.out.println("������ѯ�У�Ĭ�ϲ������ӳټ��ء������ʹ�������ʱ���Ŵ����ݿ���ȡ����-----------");
		Set<Service> ss = a.getServices();
		for(Service s : ss){
			System.out.println(s);
		}
	}
	@Test
	public void testFindByName(){
		AccountDAO dao = new AccountDAO();
		List<Account> accounts = dao.findByName("pp");
		if(accounts.size() == 1){
			Account account = accounts.iterator().next();
			System.out.println(account.getId() +","+ account.getLoginName() +","+ account.getLoginPassword() + account.getServices());
		} else {
			System.out.println("��ȡ���˶��account��������"+ accounts.size());
			for(Account account : accounts){
				System.out.println(account.getId() +","+ account.getLoginName() +","+ account.getLoginPassword() + account.getServices());
			}
		}
	}
	@Test
	public void testSave(){
		//����һ�������˺�
		Account a = new Account();
		a.setLoginName("gg");
        a.setLoginPassword("123");
        a.setRealName("gg");
        a.setIdcardNo("120392398411232449");
        a.setStatus("0");
        a.setGender(1);
        a.setTelephone("110");
        //ģ��Ҫ��ӵĲ��������¼
        Service s1 = new Service();
        s1.setAccount(a);
        s1.setOs_username("gg1");
        s1.setLogin_passwd("123");
        s1.setUnix_host("192.168.1.1");
        s1.setCost_id(5);
        s1.setStatus(0);
        Service s2 = new Service();
        s2.setAccount(a);
        s2.setOs_username("gg2");
        s2.setLogin_passwd("123");
        s2.setUnix_host("192.168.1.2");
        s2.setCost_id(5);
        s2.setStatus(0);
        //��ӹ���
        Set<Service> ss = new HashSet<Service>();
        ss.add(s1);
        ss.add(s2);
        a.setServices(ss);	//������ӹ�����һֱ���ܹ���������...
        
        AccountDAO dao = new AccountDAO();
        dao.save(a);
	}
	@Test
	public void testFindById(){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findById(2028);
		System.out.println("��ѯ����account:"+ (account == null ? "Ϊ�գ�" :(account.getId() +","+ account.getLoginName() +","+ account.getLoginPassword() + account.getServices())));
	}
	@Test
	public void testUpdate(){//���Լ����޸�
		AccountDAO dao = new AccountDAO();
//		Account account = dao.findById(2033);
//		account.setLoginName("pp");
//		Set<Service> ss = account.getServices();
//		for(Service s : ss){
//			s.setLogin_passwd("pp123");
//		}
//		dao.update(account);
//		HibernateUtil.close();
		
		List<Account> accounts = dao.findByName("gg");
		for(Account a : accounts){
			a.setLoginName("pp");
			Set<Service> ss = a.getServices();
			for(Service s : ss){
				s.setLogin_passwd("pp123");
			}
			dao.update(a);
		}
		HibernateUtil.close();
	}
	@Test
	public void testDelete(){
		AccountDAO dao = new AccountDAO();
		List<Account> accounts = dao.findByName("pp");//֪����ȡ���Ķ�����¼�ļ��ϣ���˺�һ�����ٽ��н����жϼ����ж���Ԫ�ء�
		for(Account account : accounts){
			Set<Service> services = account.getServices();
			if(services.size() == 0){//ɾ����ҵ�����û�й�����¼�ļ�¼
				dao.delete(account);
			}
		}
		HibernateUtil.close();
	}
	@Test
	public void testDelete2(){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findById(2028);
		dao.delete(account);//����쳣
				//Caused by: java.sql.BatchUpdateException: ORA-01407: �޷����� ("CHRIS"."SERVICE"."ACCOUNT_ID") Ϊ NULL
	}
	
}




















