package com.tare.netctoss.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 1.用于加载propertits文件，建立与数据库的连接
 * 2.封装JDBC的数据库事务处理方法
 * @author Administrator
 *
 */
public class BaseDao {	//Base 基础的
	private static BasicDataSource dataSource = null;
	public static Properties properties = new Properties();
	public BaseDao(){		
	}
	//用于装载属性文件获取数据库参数
	public static void init(){
		Properties prop = new Properties();
		try {
			prop.load(BaseDao.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("加载属性文件异常！");
		}
		try {
			//获取属性文件中的内容
			String driverClassName = prop.getProperty("drivername");//drivername drivername
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String initialSize = prop.getProperty("dataSource.initialSize");//连接池初始连接数
			String minIdle = prop.getProperty("dataSoure.minIdle");//最小空闲连接数
			String maxIdle = prop.getProperty("dataSource.maxIdle");//最大空闲连接数
			String maxActive = prop.getProperty("dataSource.maxActive");//连接池中最大连接数
			String maxWait = prop.getProperty("dataSource.maxWait");//最大超时时长
			
			//加载参数
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			//初始化连接数
			if (initialSize != null)
				dataSource.setInitialSize(Integer.parseInt(initialSize));
			//最小空闲连接数
			if (minIdle != null)
				dataSource.setMinIdle(Integer.parseInt(minIdle));
			//最大空闲连接数
			if (maxIdle != null)
				dataSource.setMaxIdle(Integer.parseInt(maxIdle));
			//最大超时时长
			if (maxWait != null)
				dataSource.setMaxWait(Long.parseLong(maxWait));
			//最大连接数
			if (maxActive != null) {
				if (!maxActive.trim().equals("0")) {
					dataSource.setMaxActive(Integer.parseInt(maxActive));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建连接池失败！请检查设置！！！");
		}		
	}	
	
	//从连接池中获取一个连接对象	同步安全的。静态的同步方法锁定的是类对象。类对象是唯一的，获取方式：类名.class
	public static synchronized Connection getConnection() throws SQLException{
		if(dataSource == null){
			init();
		}
		Connection conn = null;
		if(dataSource != null){
			conn = dataSource.getConnection();//抛异常
		}
		return conn;
	}
	
	/*
	 * 事务控制
	 */
	//开始	关闭自动事务提交
	public static void begin(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("关闭事务失败！");
		}
	}
	//提交事务
	public static void commit(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("提交事务失败！");
		}
	}
	//回滚事务
	public static void rollback(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("事务回滚异常！");
		}
	}
	//恢复自动提交事务
	public static void end(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("恢复自动提交事务异常！");
		}
	}
	
	//关闭方法
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("结果集关闭异常！");
				e.printStackTrace();
			} finally {
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("语句对象关闭异常!");
					} finally {
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
								System.out.println("连接对象关闭异常！");
							}
						}
					}
				}				
			}
		}
	}
}












