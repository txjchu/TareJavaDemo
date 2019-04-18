package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *	演示：使用JDBC，保存用户信息
 *  发送insert 语句
 **/
public class JdbcDemo03 {

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
		= "insert into t_user_lc"
		+ " values(1002,'LS')";
		
		//executeUpdate(),执行 insert语句
		stmt.executeUpdate(sql);
		
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}

}
