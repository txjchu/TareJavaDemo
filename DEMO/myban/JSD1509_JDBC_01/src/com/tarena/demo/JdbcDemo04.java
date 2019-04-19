package com.tarena.demo;
/**
 * 演示：Statemane接口的update 实现应用
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo04 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		
		Class.forName(driverName);
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		Statement stmt = conn.createStatement();
		
		String sql = "update t_user set name='lisi' WHERE id=1001";
		
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

