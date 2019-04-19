package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 演示：Statement接口的Delect
 * @author Administrator
 *
 */
public class JdbcDemo05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		
		Class.forName(driverName);
	
		Connection conn = DriverManager.getConnection(url,userName,password);
		Statement stmt = conn.createStatement();
		
		String sql = "delete FROM t_user WHERE id =1001";
		stmt.executeUpdate(sql);
		
		//释放资源
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
