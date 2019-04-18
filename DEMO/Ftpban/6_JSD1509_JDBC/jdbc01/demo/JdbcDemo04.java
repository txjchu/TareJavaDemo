package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 演示：更新数据
 * 
 * 需求：根据用户的ID 修改用户的姓名
 */
public class JdbcDemo04 {

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
		= "update t_user_lc "
		+ "set name='lisi' where id=1001";
		
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
