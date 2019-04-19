package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ���ӳؼ�����JDBC������
 * @author Administrator
 *
 */
public class DBUtilByPool {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	
	private static String initialSize;//��ʼ������
	private static String minIdle;//��С����������
	private static String maxIdle;//������������
	private static String maxActive;//���������
	private static String maxWait;//�ȴ���ʱʱ��
	
	private static BasicDataSource bs = null;//�������ݿ����ӳض���
	//˽�л�������
	private DBUtilByPool(){}
	//���������ļ�
	static{
		try {
			Properties prop = new Properties();//���������ļ�����
			prop.load(DBUtilByPool.class.getClassLoader().getResourceAsStream("db_01.properties"));//�����ļ��е���Ϣ��������
			//��ȡ����ֵvalue
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
			
			initialSize = prop.getProperty("dataSource.initialSize");
			minIdle = prop.getProperty("dataSource.minIdle");
			maxIdle = prop.getProperty("dataSource.maxIdle");
			maxActive = prop.getProperty("dataSource.maxActive");
			maxWait = prop.getProperty("dataSource.maxWait");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * ��ʼ��-ʵ�������ݿ����ӳ�
	 */
	private static void init(){
		bs = new BasicDataSource();//ʵ����
		//���ز���
		bs.setDriverClassName(driverName);
		bs.setUrl(url);
		bs.setUsername(userName);
		bs.setPassword(password);
		//�������ݿ����ӳصĳ�ʼֵ
		if(initialSize != null)
		bs.setInitialSize(Integer.parseInt(initialSize));
		if(minIdle != null)
		bs.setMinIdle(Integer.parseInt(minIdle));
		if(maxIdle != null)
		bs.setMaxIdle(Integer.parseInt(maxIdle));
		if(maxWait != null)
		bs.setMaxWait(Integer.parseInt(maxWait));
		if(maxActive != null){
			if(!maxActive.trim().equals("0")){
				bs.setMaxActive(Integer.parseInt(maxActive));				
			}
		}
	}
	
	/*
	 * ��ȡ���ӵķ�����ͨ��synchronized���α�֤�̰߳�ȫ��
	 */
	public static synchronized Connection getConnection(){
		if(bs == null){//�����ӳض���û��ʵ�����������ʵ��������
			init();
		}
		//��ȡ����
		Connection conn = null;
		try {
			if(bs != null)
			conn = bs.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;		
	}
	/*
	 * �ͷ���Դ�ķ���
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn){
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
	
	
	//���Դ�������
	public static void main(String[] args) {
		System.out.println(getConnection().getClass().getName());
	}
}







