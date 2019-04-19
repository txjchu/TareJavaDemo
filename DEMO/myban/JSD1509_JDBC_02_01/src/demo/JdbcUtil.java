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
 * JDBC���ظ�����
 * 
 * ��������
 * 
 * ��������
 * 
 * �ͷ���Դ
 * 
 */
//----�����࣬��������Ƴɲ�����㴴�����󣬹��췽��˽�л������ҽ�������Ϊstatic��----
public class JdbcUtil {	//----ֻҪ�õ�����࣬�ͻ�����������ͷ���Դ������ص�ʱ���Ԥ�Ȱ���������д����̬���

	//���췽��˽�л�
	private JdbcUtil(){}
	
	private static String driverName ;		//��̬���ﲻ��ֱ����ʵ��������Ҫ��static??--(fanil)
	private static String url ;
	private static String userName ;
	private static String password ;
	
	
	static{
		
		//��������
		try {
			
			//���������ļ�����
			Properties prop = new Properties();		//----��ȡһ��������
			InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(is);		//----�׳��쳣��CTRL+1��ADD...catch
			
			//��ֵ
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			
			
			Class.forName(driverName);	//----��prop.load()û�и��ӡ����ӹ�ϵ
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);	//----�׳�����ʱ�쳣���ò�����֪��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	//��������
	public static Connection getConnection() throws SQLException{
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		return conn;
	}
	
	
	//�ͷ���Դ----����ϰ��----�رչ�����˳�򣺹ؽ���������������Ӷ���
	
	
//	public static void close1(ResultSet rs,Statement stmt, Connection conn){
//		if(rs!=null){	//----����ֱ��throws�쳣����Ϊ��Ҫ��֤3�����ܹر�
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
//	//----�رշ����ڶ����
//	public static void close2(ResultSet rs,Statement stmt, Connection conn){
//		if(rs!=null){	//----����ֱ��throws�쳣����Ϊ��Ҫ��֤3�����ܹر�
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
	
	//���ͷ���Դ�ռ��桿
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		
		//----��ѡ��if��䣬�Ҽ��˵�ѡ��surround with������catch �������throw new ����ʱ�쳣��
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
