package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 演示：加载驱动程序，创建连接对象
 * @author Administrator
 *
 */
public class JdbcDemo001 {
	public static void main(String[] args) throws Exception {
		//加载驱动程序
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//获取与数据库的连接
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
//				"jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456"
		System.out.println(conn);
		//打印类名，测试conn是否创建成功
		System.out.println(conn.getClass().getName());
		System.out.println("是否连接成功");
	}
}












