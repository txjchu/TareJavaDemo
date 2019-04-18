package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	管理数据库连接的工具类
 */
public class DBUtil {
	
	private static String url;
	private static String driver;
	private static String user;
	private static String pwd;
	
	static {
		Properties p = new Properties();
		try {
			//加载db.properties
			p.load(DBUtil.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			//读取db.properties中的连接参数
			url = p.getProperty("db.url");
			driver = p.getProperty("db.driver");
			user = p.getProperty("db.user");
			pwd = p.getProperty("db.pwd");
			//加载驱动
			Class.forName(driver);
		} catch (IOException e) {
			throw new RuntimeException(
				"读取连接参数失败.", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
				"无法找到驱动类.", e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager
				.getConnection(url, user, pwd);
		} catch (SQLException e) {
			throw new RuntimeException(
				"创建连接失败.", e);
		}
	}
	
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(
					"关闭连接失败.", e);
			}
		}
	}
	
	public static void main(String[] args) {
		Connection con = DBUtil.getConnection();
		System.out.println(con);
		DBUtil.close(con);
	}
	
}







