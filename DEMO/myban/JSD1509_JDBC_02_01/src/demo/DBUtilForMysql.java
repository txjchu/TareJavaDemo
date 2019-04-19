package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 案例3	
 * @author Administrator
 *
 */
public class DBUtilForMysql {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	//工具类私有化构造方法
	private DBUtilForMysql(){};
	//加载静态资源，加载properties属性文件，并读取文件中的信息，获得创建连接所需要的参数。
	static{
		try {
			Properties prop = new Properties();
			//prop.load(inStream)方法可以将属性文件中的信息读入到属性对象中
			prop.load(DBUtilForMysql.class.getClassLoader().getResourceAsStream("db4ms.properties"));
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//加载驱动
			Class.forName(driverName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * 获取连接的方法
	 */
	private static Connection getConnection() throws SQLException{
		//创建连接对象
		Connection conn = DriverManager.getConnection(url, userName, password);
//		System.out.println(conn.getClass().getName());//是否获得了连接?
		return conn;
	}
	/*
	 * 释放资源的方法
	 */
	private static void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	
	//测试是否可以连接
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
