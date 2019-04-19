package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ����3	
 * @author Administrator
 *
 */
public class DBUtilForMysql {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	//������˽�л����췽��
	private DBUtilForMysql(){};
	//���ؾ�̬��Դ������properties�����ļ�������ȡ�ļ��е���Ϣ����ô�����������Ҫ�Ĳ�����
	static{
		try {
			Properties prop = new Properties();
			//prop.load(inStream)�������Խ������ļ��е���Ϣ���뵽���Զ�����
			prop.load(DBUtilForMysql.class.getClassLoader().getResourceAsStream("db4ms.properties"));
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//��������
			Class.forName(driverName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * ��ȡ���ӵķ���
	 */
	private static Connection getConnection() throws SQLException{
		//�������Ӷ���
		Connection conn = DriverManager.getConnection(url, userName, password);
//		System.out.println(conn.getClass().getName());//�Ƿ���������?
		return conn;
	}
	/*
	 * �ͷ���Դ�ķ���
	 */
	private static void close(ResultSet rs, Statement stmt, Connection conn){
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
	
	//�����Ƿ��������
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
