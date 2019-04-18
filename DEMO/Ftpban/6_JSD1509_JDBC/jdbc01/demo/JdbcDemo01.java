package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 演示：加载驱动程序，创建连接对象
 */
public class JdbcDemo01 {

	public static void main(String[] args)
			throws ClassNotFoundException
			, SQLException {
		
		//加载驱动程序
		Class.forName
		("oracle.jdbc.driver.OracleDriver");
		
		//获取与数据库的连接
		Connection conn
		= DriverManager.getConnection
		("jdbc:oracle:thin:@192.168.201.220:1521:orcl",
		"openlab","open123");
		
		System.out.println(conn);
		//打印类名
		System.out.println
		(conn.getClass().getName());
	}
}
