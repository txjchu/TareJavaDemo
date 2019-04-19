package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 演示：创建语句对象，使用语句对象
 * 
 *语句对象：提供向数据库发送SQL的API
 *
 */
public class JdbcDemo02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动，创建连接
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//----如果是Linux 下xe换成orcl
		String userName = "chris";
		String password = "123456";
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		//2.创建语句对象,执行SQL语句
		Statement stmt = conn.createStatement();
		
		//--执行DDL语句
		String sql = "create table t_user(id number(4) primary key,name varchar2(10))";
		stmt.execute(sql);

		//4.释放资源，关闭语句对象，关闭连接对象
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
