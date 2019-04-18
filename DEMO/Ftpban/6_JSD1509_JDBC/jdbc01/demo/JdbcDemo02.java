package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 演示：创建语句对象，使用语句对象，发送DDL
 * 
 * 语句对象：提供向数据库发送SQL的API
 * 
 **/
public class JdbcDemo02 {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {
		
		//1、加载驱动，创建连接
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
		
		//2、创建语句对象，执行SQL语句
		Statement stmt
		= conn.createStatement();
		
		String sql
		= "create table t_user_lc"
		+ "(id number(4) primary key"
		+ ",name varchar2(10))";
		//执行DDL语句
		stmt.execute(sql);		
		
		//3、释放资源  关闭语句对象，关闭连接对象
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
