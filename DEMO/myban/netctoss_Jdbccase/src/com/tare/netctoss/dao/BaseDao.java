package com.tare.netctoss.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 1.���ڼ���propertits�ļ������������ݿ������
 * 2.��װJDBC�����ݿ���������
 * @author Administrator
 *
 */
public class BaseDao {	//Base ������
	private static BasicDataSource dataSource = null;
	public static Properties properties = new Properties();
	public BaseDao(){		
	}
	//����װ�������ļ���ȡ���ݿ����
	public static void init(){
		Properties prop = new Properties();
		try {
			prop.load(BaseDao.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("���������ļ��쳣��");
		}
		try {
			//��ȡ�����ļ��е�����
			String driverClassName = prop.getProperty("drivername");//drivername drivername
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String initialSize = prop.getProperty("dataSource.initialSize");//���ӳس�ʼ������
			String minIdle = prop.getProperty("dataSoure.minIdle");//��С����������
			String maxIdle = prop.getProperty("dataSource.maxIdle");//������������
			String maxActive = prop.getProperty("dataSource.maxActive");//���ӳ������������
			String maxWait = prop.getProperty("dataSource.maxWait");//���ʱʱ��
			
			//���ز���
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			//��ʼ��������
			if (initialSize != null)
				dataSource.setInitialSize(Integer.parseInt(initialSize));
			//��С����������
			if (minIdle != null)
				dataSource.setMinIdle(Integer.parseInt(minIdle));
			//������������
			if (maxIdle != null)
				dataSource.setMaxIdle(Integer.parseInt(maxIdle));
			//���ʱʱ��
			if (maxWait != null)
				dataSource.setMaxWait(Long.parseLong(maxWait));
			//���������
			if (maxActive != null) {
				if (!maxActive.trim().equals("0")) {
					dataSource.setMaxActive(Integer.parseInt(maxActive));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ӳ�ʧ�ܣ��������ã�����");
		}		
	}	
	
	//�����ӳ��л�ȡһ�����Ӷ���	ͬ����ȫ�ġ���̬��ͬ��������������������������Ψһ�ģ���ȡ��ʽ������.class
	public static synchronized Connection getConnection() throws SQLException{
		if(dataSource == null){
			init();
		}
		Connection conn = null;
		if(dataSource != null){
			conn = dataSource.getConnection();//���쳣
		}
		return conn;
	}
	
	/*
	 * �������
	 */
	//��ʼ	�ر��Զ������ύ
	public static void begin(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ر�����ʧ�ܣ�");
		}
	}
	//�ύ����
	public static void commit(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ύ����ʧ�ܣ�");
		}
	}
	//�ع�����
	public static void rollback(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ع��쳣��");
		}
	}
	//�ָ��Զ��ύ����
	public static void end(){
		try {
			Connection conn = getConnection();
			if(conn != null){
				conn.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ָ��Զ��ύ�����쳣��");
		}
	}
	
	//�رշ���
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("������ر��쳣��");
				e.printStackTrace();
			} finally {
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("������ر��쳣!");
					} finally {
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
								System.out.println("���Ӷ���ر��쳣��");
							}
						}
					}
				}				
			}
		}
	}
}












