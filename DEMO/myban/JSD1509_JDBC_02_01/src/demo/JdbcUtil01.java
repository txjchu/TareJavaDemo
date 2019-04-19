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
 * JDBC中的重复操作
 * 加载驱动	创建连接	释放资源
 * @author Administrator
 *
 */
public class JdbcUtil01 {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	//构造方法私有化
	private JdbcUtil01(){}
	
	//加载驱动，静态块
	static{
		try {
			//加载属性文件数据
			Properties prop = new Properties();
			//获取输入流。	先通过加载资源-属性文件，然后调用方法获得输入流。
			InputStream is = JdbcUtil01.class.getClassLoader().getResourceAsStream("db_01.properties");
			prop.load(is);
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//加载驱动程序
			Class.forName(driverName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//创建连接
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	//释放资源方法
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					} finally {
						try {
							if(conn != null){
								conn.close();
							}
						} catch (SQLException e) {
							e.printStackTrace();
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
	}
	
	//测试是否可以连接
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}













