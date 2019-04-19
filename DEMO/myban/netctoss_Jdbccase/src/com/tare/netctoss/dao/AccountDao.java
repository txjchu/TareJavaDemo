package com.tare.netctoss.dao;

import java.sql.SQLException;
import java.util.List;

import com.tare.netctoss.entity.Account;

/**
 * AccountDao接口
 * 封装具体操作数据库Account表的方法：增删改查
 * @author Administrator
 *
 */
public interface AccountDao {
	
	/**
	 * 查：按照给定Id查询Account表中的记录
	 * @param id 某个账号的ID
	 * @return Account 该ID的账务账号的所有信息，以Account对象形式返回。
	 * @throws SQLException
	 */
	Account findById(Integer id) throws SQLException;
	
	/**
	 * 查：查询Account表中的所有记录，并以Account集合的形式返回
	 * @return List<Account> Account集合的形式返回
	 * @throws SQLException
	 */
	List<Account> findAll() throws SQLException;
	
	/**
	 * 增：向Account表中添加记录
	 * @param account	要添加进表中的对象
	 * @return Account 	添加后的账号信息，包含账号账号ID
	 * @throws SQLException
	 */
	Account save(Account account) throws SQLException;
	
	
	/**
	 * 改：修改表中的某条记录
	 * @param account	要修改的记录对象
	 * @return account 	被修改后的记录对象
	 * @throws SQLException
	 */
	Account modify(Account account) throws SQLException;
	
	
	/**
	 * 改：修改表中某条记录的状态
	 * @param account	要修改的记录对象
	 * @return account	被修改后的记录对象
	 * @throws SQLException
	 */
	Account modifyStatus(Account account) throws SQLException;
}
