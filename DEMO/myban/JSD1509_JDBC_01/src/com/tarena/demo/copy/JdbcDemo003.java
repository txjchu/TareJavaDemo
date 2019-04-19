package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 演示：使用JDBC，保护用户信息发送insert语句
 * @author Administrator
 *
 */
public class JdbcDemo003 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String passWord = "123456";
		//1.加载驱动
		Class.forName(driverName);
		//2.获取连接
		Connection conn = DriverManager.getConnection(url, userName, passWord);
		//3.获取语句对象
		Statement stmt = conn.createStatement();
		String sql = 
//						"INSERT INTO t_user_lc values(1002, 'LS');" +
//						"INSERT INTO t_user_lc VALUES(1003, 'ZHANG');" +
//						"INSERT INTO t_user_lc VALUES(1004, 'WANG');" +
						"INSERT INTO t_user_lc VALUES(1005, 'LI')";//创建DML语句
		//4.执行SQL
		int dml =  stmt.executeUpdate(sql);
		System.out.println("语句执行后影响了多少记录："+ dml);
		
		//5.关闭对象
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}












