package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 演示：创建语句对象，使用语句对象，发送DDL
 * 语句对象：提供向数据库发送SQL的API
 * @author Administrator
 *
 */
public class JdbcDemo002 {
	public static void main(String[] args) throws Exception {
		//1.加载驱动，创建连接
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String passWord = "123456";
		Connection conn = DriverManager.getConnection(url, userName, passWord);
		System.out.println("是否连接："+ conn.getClass().getName());
		
		//2.创建语句对象，执行SQL语句
		Statement stmt = conn.createStatement();
		String sql = "create table t_user_lc(id number(4) primary key, name varchar2(20))";
		//执行DDL语句
		boolean flag = stmt.execute(sql);
		System.out.println(flag);
		//3.释放资源，关闭语句对象，关闭连接对象
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}











