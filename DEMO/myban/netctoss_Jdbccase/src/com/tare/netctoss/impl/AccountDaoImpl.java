package com.tare.netctoss.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tare.netctoss.dao.AccountDao;
import com.tare.netctoss.dao.AccountMapper;
import com.tare.netctoss.dao.BaseDao;
import com.tare.netctoss.entity.Account;

/**
 * 
 * @author Administrator
 *
 */
public class AccountDaoImpl extends BaseDao implements AccountDao{
	private static final String FIND_ALL = "select ACCOUNT_ID, RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD,"
            									+ " STATUS, CREATE_DATE, PAUSE_DATE, CLOSE_DATE, REAL_NAME, IDCARD_NO, BIRTHDATE, GENDER, OCCUPATION,"
            									+ "TELEPHONE,EMAIL,MAILADDRESS,ZIPCODE,QQ,LAST_LOGIN_TIME,LAST_LOGIN_IP from account";
	private static final String SELECT_BY_ID = "select ACCOUNT_ID, RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD,"
            									+ " STATUS, CREATE_DATE, PAUSE_DATE, CLOSE_DATE, REAL_NAME, IDCARD_NO, BIRTHDATE, GENDER, OCCUPATION,"
            									+ "TELEPHONE,EMAIL,MAILADDRESS,ZIPCODE,QQ,LAST_LOGIN_TIME,LAST_LOGIN_IP from account where account_id = ?";
	private static final String INSERT = "INSERT INTO ACCOUNT(ACCOUNT_ID, RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD,"
												+ " STATUS, CREATE_DATE, PAUSE_DATE, CLOSE_DATE, REAL_NAME, IDCARD_NO, BIRTHDATE, GENDER, OCCUPATION,"
												+ "TELEPHONE,EMAIL,MAILADDRESS,ZIPCODE,QQ,LAST_LOGIN_TIME,LAST_LOGIN_IP) "
												+ " VALUES (ACCOUNT_SEQ.NEXTVAL,?, ?, ?, '0', SYSDATE, NULL, NULL,?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
	private static final String UPDATE_STATUS = "UPDATE ACCOUNT SET STATUS = ? WHERE ACCOUNT_ID=?";
	private static final String MODIFY = "UPDATE ACCOUNT SET LOGIN_PASSWD = ?, REAL_NAME = ?,  GENDER = ?, OCCUPATION = ?,"
            									+ "TELEPHONE = ?,EMAIL = ?,MAILADDRESS = ?,ZIPCODE = ?,QQ = ? WHERE ACCOUNT_ID=?";
	
	//查询所有记录的方法
	@Override
	public List<Account> findAll() throws SQLException {
		List<Account> accounts = new ArrayList<Account>();
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(FIND_ALL);
		ResultSet rs = ps.executeQuery();
		Account account = null;
		while(rs.next()){
			account = AccountMapper.accountMapper(rs);
			accounts.add(account);
		}
		return accounts;
	}
	
	//按照给定ID查询记录的方法
	@Override
	public Account findById(Integer id) throws SQLException {
		Account account = new Account();
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			account = AccountMapper.accountMapper(rs);
		}
		BaseDao.close(rs, ps, conn);
		return account;
	}
	//修改表中记录的方法
	@Override
	public Account modify(Account account) throws SQLException {
		Connection conn = BaseDao.getConnection();
		Account account_fromdb = this.findById(account.getId());
		if(account_fromdb == null){
			return null;
		}
		PreparedStatement ps = conn.prepareStatement(MODIFY);
		ps.setString(1, account.getLoginPasswd());
		ps.setString(2, account.getRealName());
		ps.setString(3, account.getGender());
		ps.setString(4, account.getOccupation());
		ps.setString(5, account.getTelephone());
		ps.setString(6, account.getEmail());
		ps.setString(7, account.getMailaddress());
		ps.setString(8, account.getZipcode());
		ps.setString(9, account.getQq());
		ps.setInt(10, account.getId());
		int flag = ps.executeUpdate();
		BaseDao.close(null, ps, conn);
		
		return (flag > 0) ? account : null;
	}
	
	//修改指定Account对象表中记录的status状态
	@Override
	public Account modifyStatus(Account account) throws SQLException {
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = conn.prepareStatement(UPDATE_STATUS);
		String status = account.getStatus();
		int id = account.getId();
		ps.setString(1, status);
		ps.setInt(2, id);
		int flag = ps.executeUpdate();
		BaseDao.close(null, ps, conn);
		return (flag > 0) ? account : null;
	}
	
	//将给定的Account对象保存到数据表中
	@Override
	public Account save(Account account) throws SQLException {
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT, new String[]{"account_id"});//将SQL语句放入语句对象，并指定获取主键的字段
		
		Calendar c = Calendar.getInstance();
		String birth = c.get(Calendar.YEAR) +"-"+ c.get(Calendar.MONTH) +"-"+ c.get(Calendar.DATE);
		
        ps.setInt(1, account.getRecommenderId());
        ps.setString(2, account.getLoginName());
        ps.setString(3, account.getLoginPasswd());
        ps.setString(4, account.getRealName());
        ps.setString(5, account.getIdcardNo());
        ps.setString(6, birth);
        ps.setString(7, account.getGender());
        ps.setString(8, account.getOccupation());
        ps.setString(9, account.getTelephone());
        ps.setString(10, account.getEmail());
        ps.setString(11, account.getMailaddress());
        ps.setString(12, account.getZipcode());
        ps.setString(13, account.getQq());
        ps.setString(14, account.getLastLoginIp());
        
		ps.executeUpdate();
		//将自动生成的主键account_id赋值给实体类对象，并返回。
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		account.setId(id);
		
        
		return account;
	}
		
}
