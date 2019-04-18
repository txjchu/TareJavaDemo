package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ʾ������������ʹ�������󣬷���DDL
 * 
 * �������ṩ�����ݿⷢ��SQL��API
 * 
 **/
public class JdbcDemo02 {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {
		
		//1��������������������
		String driverName
		= "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		String url
		= "jdbc:oracle:thin:@192.168."
		+ "201.220:1521:orcl";
		String userName = "openlab";
		String password = "open123";
		
		Connection conn
		= DriverManager.getConnection
		(url,userName,password); 
		
		//2������������ִ��SQL���
		Statement stmt
		= conn.createStatement();
		
		String sql
		= "create table t_user_lc"
		+ "(id number(4) primary key"
		+ ",name varchar2(10))";
		//ִ��DDL���
		stmt.execute(sql);		
		
		//3���ͷ���Դ  �ر������󣬹ر����Ӷ���
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
