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
 * JDBC������
 * 
 * JDBC�е��ظ�����
 * ��������	��������	�ͷ���Դ
 * @author Administrator
 *
 */
public class JdbcUtil01 {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	//���췽��˽�л�
	private JdbcUtil01(){}
	
	//������������̬��
	static{
		try {
			//���������ļ�����
			Properties prop = new Properties();
			//��ȡ��������	��ͨ��������Դ-�����ļ���Ȼ����÷��������������
			InputStream is = JdbcUtil01.class.getClassLoader().getResourceAsStream("db_01.properties");
			prop.load(is);
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//������������
			Class.forName(driverName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//��������
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	//�ͷ���Դ����
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
	
	//�����Ƿ��������
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}













