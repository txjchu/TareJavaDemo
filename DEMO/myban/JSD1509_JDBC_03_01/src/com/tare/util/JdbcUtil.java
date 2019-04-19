package com.tare.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * �������ӵĹ�����
 * @author Administrator
 *
 */
public class JdbcUtil {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	
	//˽�й�����
	private JdbcUtil(){}
	
	/*
	 * ���ؾ�̬��Դ
	 */
	static{
		try {
			Properties prop = new Properties();//�������Զ���������ȡ�����ļ��е�����
			prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			//��������
			Class.forName(driverName);
			
		} catch (IOException e) {
			System.out.println("������ȡ�����ļ�������ʧ�ܣ�");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("���������쳣��");
			e.printStackTrace();
		}		
	}
	
	/*
	 * ��ȡ���ӵķ���
	 */
	public static Connection getConnection() throws SQLException{
		//��ȡ����
		Connection conn = DriverManager.getConnection(url, userName, password);			
		return conn;
	}
	/*
	 * �ͷ���Դ
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("�رս�����쳣��");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println("�ر��������쳣��");
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
					System.out.println("�ر������쳣��");
				}
			}
		}
	}
	
	//�����Ƿ����ӳɹ�
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection().getClass().getName());
	}
}











