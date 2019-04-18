package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	�������ݿ����ӵĹ�����
 */
public class DBUtil {
	
	private static String url;
	private static String driver;
	private static String user;
	private static String pwd;
	
	static {
		Properties p = new Properties();
		try {
			//����db.properties
			p.load(DBUtil.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			//��ȡdb.properties�е����Ӳ���
			url = p.getProperty("db.url");
			driver = p.getProperty("db.driver");
			user = p.getProperty("db.user");
			pwd = p.getProperty("db.pwd");
			//��������
			Class.forName(driver);
		} catch (IOException e) {
			throw new RuntimeException(
				"��ȡ���Ӳ���ʧ��.", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
				"�޷��ҵ�������.", e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager
				.getConnection(url, user, pwd);
		} catch (SQLException e) {
			throw new RuntimeException(
				"��������ʧ��.", e);
		}
	}
	
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(
					"�ر�����ʧ��.", e);
			}
		}
	}
	
	public static void main(String[] args) {
		Connection con = DBUtil.getConnection();
		System.out.println(con);
		DBUtil.close(con);
	}
	
}







