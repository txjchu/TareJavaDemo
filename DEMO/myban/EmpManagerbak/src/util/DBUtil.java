package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 管理数据库连接的工具类
 */
public class DBUtil {
		private static String driver;
		private static String url;
		private static String  user;
		private static String pwd;
		static{
			//读取properties中的连接参数
			Properties prop=new Properties();
			try {
				//读取db.properties
				InputStream is=DBUtil.class.getClassLoader().getResourceAsStream("DB.properties");
				prop.load(is);
				 driver=prop.getProperty("db.driver");
				url=prop.getProperty("db.url");
				 user=prop.getProperty("db.user");
				 pwd=prop.getProperty("db.pwd");
					Class.forName(driver);	
			} catch (IOException e) {
				throw new RuntimeException("读取连接参数失败.",e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("无法找到驱动类",e);
			}
		}
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url,user,pwd);
			return conn;
		} catch (SQLException e) {	
			throw new RuntimeException("创建连接失败",e);
		}
	}

	public  static void close(Connection conn)  {
				try {
					if(conn!=null){
					conn.close();
					}
				} catch (SQLException e) {	
					throw new RuntimeException("关闭连接",e);
				}
	}
	public static void main(String[] args) {
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}
}
