package org.tare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCUtil工具类获取连接
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static Connection conn = null;
	
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs, Statement s, Connection conn ){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(s != null){
					try {
						s.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				} 
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
