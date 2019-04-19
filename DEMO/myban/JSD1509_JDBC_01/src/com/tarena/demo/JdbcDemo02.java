package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ʾ������������ʹ��������
 * 
 *�������ṩ�����ݿⷢ��SQL��API
 *
 */
public class JdbcDemo02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.������������������
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//----�����Linux ��xe����orcl
		String userName = "chris";
		String password = "123456";
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		//2.����������,ִ��SQL���
		Statement stmt = conn.createStatement();
		
		//--ִ��DDL���
		String sql = "create table t_user(id number(4) primary key,name varchar2(10))";
		stmt.execute(sql);

		//4.�ͷ���Դ���ر������󣬹ر����Ӷ���
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
