package com.tare.netctoss.dao;

import java.sql.SQLException;
import java.util.List;

import com.tare.netctoss.entity.Account;

/**
 * AccountDao�ӿ�
 * ��װ����������ݿ�Account��ķ�������ɾ�Ĳ�
 * @author Administrator
 *
 */
public interface AccountDao {
	
	/**
	 * �飺���ո���Id��ѯAccount���еļ�¼
	 * @param id ĳ���˺ŵ�ID
	 * @return Account ��ID�������˺ŵ�������Ϣ����Account������ʽ���ء�
	 * @throws SQLException
	 */
	Account findById(Integer id) throws SQLException;
	
	/**
	 * �飺��ѯAccount���е����м�¼������Account���ϵ���ʽ����
	 * @return List<Account> Account���ϵ���ʽ����
	 * @throws SQLException
	 */
	List<Account> findAll() throws SQLException;
	
	/**
	 * ������Account������Ӽ�¼
	 * @param account	Ҫ��ӽ����еĶ���
	 * @return Account 	��Ӻ���˺���Ϣ�������˺��˺�ID
	 * @throws SQLException
	 */
	Account save(Account account) throws SQLException;
	
	
	/**
	 * �ģ��޸ı��е�ĳ����¼
	 * @param account	Ҫ�޸ĵļ�¼����
	 * @return account 	���޸ĺ�ļ�¼����
	 * @throws SQLException
	 */
	Account modify(Account account) throws SQLException;
	
	
	/**
	 * �ģ��޸ı���ĳ����¼��״̬
	 * @param account	Ҫ�޸ĵļ�¼����
	 * @return account	���޸ĺ�ļ�¼����
	 * @throws SQLException
	 */
	Account modifyStatus(Account account) throws SQLException;
}
