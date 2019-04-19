package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 演示：使用JDBC保存用户信息（发送 insert语句）。
 * 
 *
 */
public class JdbcDemo03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		Statement stmt = conn.createStatement();
		
		String sql = "insert into t_user VALUES(1002,'ls')";
		
		//executeUpdate(),执行insert语句
		stmt.executeUpdate(sql);
		
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
