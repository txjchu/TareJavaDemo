package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * �������ݿ����ӵĹ�����
 */
public class DBUtil {
		private static String driver;
		private static String url;
		private static String  user;
		private static String pwd;
		static{
			//��ȡproperties�е����Ӳ���
			Properties prop=new Properties();
			try {
				//��ȡdb.properties
				InputStream is=DBUtil.class.getClassLoader().getResourceAsStream("DB.properties");
				prop.load(is);
				 driver=prop.getProperty("db.driver");
				url=prop.getProperty("db.url");
				 user=prop.getProperty("db.user");
				 pwd=prop.getProperty("db.pwd");
					Class.forName(driver);	
			} catch (IOException e) {
				throw new RuntimeException("��ȡ���Ӳ���ʧ��.",e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("�޷��ҵ�������",e);
			}
		}
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url,user,pwd);
			return conn;
		} catch (SQLException e) {	
			throw new RuntimeException("��������ʧ��",e);
		}
	}

	public  static void close(Connection conn)  {
				try {
					if(conn!=null){
					conn.close();
					}
				} catch (SQLException e) {	
					throw new RuntimeException("�ر�����",e);
				}
	}
	public static void main(String[] args) {
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}
}
