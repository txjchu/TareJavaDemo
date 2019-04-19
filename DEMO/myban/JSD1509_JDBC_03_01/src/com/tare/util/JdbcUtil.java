package com.tare.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 创建连接的工具类
 * @author Administrator
 *
 */
public class JdbcUtil {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	
	//私有构造器
	private JdbcUtil(){}
	
	/*
	 * 加载静态资源
	 */
	static{
		try {
			Properties prop = new Properties();//创建属性对象，用来读取属性文件中的数据
			prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//加载驱动
			Class.forName(driverName);
			
		} catch (IOException e) {
			System.out.println("创建读取属性文件输入流失败！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常！");
			e.printStackTrace();
		}		
	}
	
	/*
	 * 获取连接的方法
	 */
	public static Connection getConnection() throws SQLException{
		//获取连接
		Connection conn = DriverManager.getConnection(url, userName, password);			
		return conn;
	}
	/*
	 * 释放资源
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭结果集异常！");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println("关闭语句对象异常！");
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
					System.out.println("关闭连接异常！");
				}
			}
		}
	}
	
	//测试是否连接成功
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection().getClass().getName());
	}
}











