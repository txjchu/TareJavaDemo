package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 创建数据库连接工具类
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	//加载静态资源，加载属性文件
	static{
		Properties prop = new Properties();
		InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(is);
			drivername = prop.getProperty("driverName");
			url = prop.getProperty("url");
			username = prop.getProperty("userName");
			password = prop.getProperty("password");			
			
			//加载驱动
			Class.forName(drivername);
		} catch (IOException e) {
			System.out.println("加载静态资源异常！");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	//获取连接方法
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	//关闭连接方法
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} 
		}
	}
}
