package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 连接池技术的JDBC工具类
 * @author Administrator
 *
 */
public class DBUtilByPool {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	
	private static String initialSize;//初始连接数
	private static String minIdle;//最小空闲连接数
	private static String maxIdle;//最大空闲连接数
	private static String maxActive;//最大连接数
	private static String maxWait;//等待超时时长
	
	private static BasicDataSource bs = null;//创建数据库连接池对象
	//私有化构造器
	private DBUtilByPool(){}
	//加载属性文件
	static{
		try {
			Properties prop = new Properties();//创建属性文件对象
			prop.load(DBUtilByPool.class.getClassLoader().getResourceAsStream("db_01.properties"));//加载文件中的信息到对象中
			//获取属性值value
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			
			initialSize = prop.getProperty("dataSource.initialSize");
			minIdle = prop.getProperty("dataSource.minIdle");
			maxIdle = prop.getProperty("dataSource.maxIdle");
			maxActive = prop.getProperty("dataSource.maxActive");
			maxWait = prop.getProperty("dataSource.maxWait");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * 初始化-实例化数据库连接池
	 */
	private static void init(){
		bs = new BasicDataSource();//实例化
		//加载参数
		bs.setDriverClassName(driverName);
		bs.setUrl(url);
		bs.setUsername(userName);
		bs.setPassword(password);
		//设置数据库连接池的初始值
		if(initialSize != null)
		bs.setInitialSize(Integer.parseInt(initialSize));
		if(minIdle != null)
		bs.setMinIdle(Integer.parseInt(minIdle));
		if(maxIdle != null)
		bs.setMaxIdle(Integer.parseInt(maxIdle));
		if(maxWait != null)
		bs.setMaxWait(Integer.parseInt(maxWait));
		if(maxActive != null){
			if(!maxActive.trim().equals("0")){
				bs.setMaxActive(Integer.parseInt(maxActive));				
			}
		}
	}
	
	/*
	 * 获取连接的方法，通过synchronized修饰保证线程安全。
	 */
	public static synchronized Connection getConnection(){
		if(bs == null){//若连接池对象没有实例化。则调用实例化方法
			init();
		}
		//获取连接
		Connection conn = null;
		try {
			if(bs != null)
			conn = bs.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;		
	}
	/*
	 * 释放资源的方法
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn){
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
	
	
	//测试创建连接
	public static void main(String[] args) {
		System.out.println(getConnection().getClass().getName());
	}
}







