package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 演示：加载驱动程序
 * @author Administrator
 *
 */
public class JdbcDemo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//加载驱动程序
		Class.forName("oracle.jdbc.driver.OracleDriver");	//	将Oracle提供的驱动加载到内存中
		
		//获取与数据库的连接----通过DriverManager.getConnection("")
//		DriverManager.getConnection("url","userName","password");	//----localhost
		Connection conn =
		DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","chris","123456");
		
		System.out.println(conn);
		//打印类名
		System.out.println(conn.getClass().getName());
		
	}
}
