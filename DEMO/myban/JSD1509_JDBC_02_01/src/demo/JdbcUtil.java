package demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * 
 * JDBC中重复操作
 * 
 * 加载驱动
 * 
 * 创建连接
 * 
 * 释放资源
 * 
 */
//----工具类，尽可能设计成不能随便创建对象，构造方法私有化；并且将方法设为static。----
public class JdbcUtil {	//----只要用到这个类，就会加载驱动，释放资源，类加载的时候就预先把连接驱动写到静态块里。

	//构造方法私有化
	private JdbcUtil(){}
	
	private static String driverName ;		//静态块里不能直接用实例变量，要加static??--(fanil)
	private static String url ;
	private static String userName ;
	private static String password ;
	
	
	static{
		
		//加载驱动
		try {
			
			//加载属性文件数据
			Properties prop = new Properties();		//----获取一个输入流
			InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(is);		//----抛出异常，CTRL+1，ADD...catch
			
			//赋值
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			
			
			Class.forName(driverName);	//----与prop.load()没有父子、连接关系
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);	//----抛出运行时异常，让操作者知道
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	//创建连接
	public static Connection getConnection() throws SQLException{
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		return conn;
	}
	
	
	//释放资源----操作习惯----关闭过对象顺序：关结果集，语句对象，连接对象
	
	
//	public static void close1(ResultSet rs,Statement stmt, Connection conn){
//		if(rs!=null){	//----不能直接throws异常，因为需要保证3个都能关闭
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if(stmt!=null){
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if(conn!=null){
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	//----关闭方法第二版版
//	public static void close2(ResultSet rs,Statement stmt, Connection conn){
//		if(rs!=null){	//----不能直接throws异常，因为需要保证3个都能关闭
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw new RuntimeException(e);
//				
//			}
//		}
//		
//		if(stmt!=null){
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw new RuntimeException(e);
//			}
//		}
//		if(conn!=null){
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw new RuntimeException(e);
//			}
//		}
//	}
	
	//【释放资源终极版】
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		
		//----【选中if语句，右键菜单选中surround with，并在catch 里面添加throw new 运行时异常】
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
