package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * �������ݿ����ӹ�����
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	//���ؾ�̬��Դ�����������ļ�
	static{
		Properties prop = new Properties();
		InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(is);
			drivername = prop.getProperty("driverName");
			url = prop.getProperty("url");
			username = prop.getProperty("userName");
			password = prop.getProperty("password");			
			
			//��������
			Class.forName(drivername);
		} catch (IOException e) {
			System.out.println("���ؾ�̬��Դ�쳣��");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("���������쳣��");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	//��ȡ���ӷ���
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	//�ر����ӷ���
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
