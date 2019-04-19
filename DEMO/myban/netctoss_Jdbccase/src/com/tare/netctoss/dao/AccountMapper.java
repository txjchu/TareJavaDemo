package com.tare.netctoss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tare.netctoss.entity.Account;

/**
 * Account类对象与结果集中的记录对映，该类将结果集中的记录转换为一个Account对象。
 * @author Administrator
 *
 */
public class AccountMapper {
//	private ResultSet rs = null;
	
	
	public static Account accountMapper(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("ACCOUNT_ID"));
		account.setRecommenderId(rs.getInt("RECOMMENDER_ID"));
		account.setLoginName(rs.getString("login_name"));
		account.setLoginPasswd(rs.getString("login_passwd"));
		account.setStatus(rs.getString("status"));
		account.setCreateDate(rs.getDate("create_date"));//SQLDATE --> UTILDATE
		account.setPauseDate(rs.getDate("pause_date"));
		account.setCloseDate(rs.getDate("close_date"));
		account.setRealName(rs.getString("real_name"));
		account.setIdcardNo(rs.getString("idcard_no"));
		account.setBirthdate(rs.getDate("birthdate"));
		account.setGender(rs.getString("gender"));
		account.setOccupation(rs.getString("occupation"));
		account.setTelephone(rs.getString("telephone"));
		account.setEmail(rs.getString("email"));
		account.setMailaddress(rs.getString("mailaddress"));
		account.setZipcode(rs.getString("zipcode"));
		account.setQq(rs.getString("qq"));
		account.setLastLoginTime(rs.getDate("last_login_time"));
		account.setLastLoginIp(rs.getString("last_login_ip"));
		
		return account;
	}
}













