package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ʾ��ɾ������
 * 
 * ���󣺸����û���ID ɾ���û���Ϣ
 */
public class JdbcDemo05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168."
				+ "201.220:1521:orcl";
		String userName = "openlab";
		String password = "open123";
		
		Class.forName(driverName);
		
		Connection conn
		= DriverManager.getConnection(url,userName,password);
		
		Statement stmt
		= conn.createStatement();
		
		String sql
		= "delete from "
		+ "t_user_lc where id=1001";
		
		stmt.executeUpdate(sql);
		
		//�ͷ���Դ
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
