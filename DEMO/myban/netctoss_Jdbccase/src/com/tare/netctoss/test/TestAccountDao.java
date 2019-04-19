package com.tare.netctoss.test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tare.netctoss.dao.AccountDao;
import com.tare.netctoss.entity.Account;
import com.tare.netctoss.impl.AccountDaoImpl;

/**
 * ������
 * @author Administrator
 *
 */
public class TestAccountDao {
	
	//����ʵ�����е�findAll����
	@Test
	public void testFindAll(){
		AccountDaoImpl adi = new AccountDaoImpl();
		try {
			List<Account> list = adi.findAll();
			System.out.println("id\tloginName\tloginpasswd");
			for(Account a : list){
				System.out.println(a.getId() +"\t"+ a.getLoginName() +"\t"+ a.getLoginPasswd());
				System.out.println(a);
			}
		} catch (SQLException e) {
			System.out.println("findAll�����쳣��");
			e.printStackTrace();
		}		
	}
	//����findById
	@Test
	public void testFindById(){
		AccountDaoImpl adi = new AccountDaoImpl();
		int id = 2001;
		try {
			Account account = adi.findById(id);
			System.out.println(account.getId() +","+ account.getLoginName() +","+ account.getLoginPasswd());
		} catch (SQLException e) {
			System.out.println("findById�����쳣��");
			e.printStackTrace();
		}
	}
	
	//����save����
	@Test
	public void testSave(){
		Calendar c = Calendar.getInstance();
		c.set(1990, 12, 22);
		Date birth = c.getTime(); //util.Date
		
        Account account = new Account();
        account.setRecommenderId(2001);
        account.setLoginName("hit");
        account.setLoginPasswd("123");
        account.setRealName("zs");
        account.setIdcardNo("007");
        account.setBirthdate(birth);
        account.setGender("0");
        account.setOccupation("student");
        account.setTelephone("tel1234");
        account.setEmail("a@b.c");
        account.setMailaddress("126 avenue");
        account.setZipcode("1071");
        account.setQq("1111");
        account.setLastLoginIp("192");
		
		AccountDao dao = new AccountDaoImpl();
		try {
			dao.save(account);
		} catch (SQLException e) {
			System.out.println("����SAVE�����쳣��");
			e.printStackTrace();
		}		
	}
	
	//�����޸ı��м�¼�ķ���
	@Test
	public void testModify(){
		Calendar c = Calendar.getInstance();
		c.set(1992, 5, 3);
		Date birth = c.getTime();
		
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		
		account.setRecommenderId(2001);
        account.setId(2003);
        account.setLoginName("hitmo");
        account.setLoginPasswd("123mo");
        account.setRealName("zsmo");
        account.setIdcardNo("007mo");
        account.setBirthdate(birth);
        account.setGender("1");
        account.setOccupation("studentmo");
        account.setTelephone("tel1234mo");
        account.setEmail("a@b.cmo");
        account.setMailaddress("126 avenue mo");
        account.setZipcode("1071mo");
        account.setQq("1111mo");
        account.setLastLoginIp("192.mo");
        try {
			account = dao.modify(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println(account.toString());
	}
	//�����޸�ָ����¼��״̬
	@Test
	public void testModifyStatus(){
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		account.setId(2003);
		account.setStatus("2");//0:��ͨ��1����ͣ��2��ɾ��
		try {
			account = dao.modifyStatus(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(account);
	}
	
}
















