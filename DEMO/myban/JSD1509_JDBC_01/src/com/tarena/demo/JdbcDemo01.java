package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��ʾ��������������
 * @author Administrator
 *
 */
public class JdbcDemo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//������������
		Class.forName("oracle.jdbc.driver.OracleDriver");	//	��Oracle�ṩ���������ص��ڴ���
		
		//��ȡ�����ݿ������----ͨ��DriverManager.getConnection("")
//		DriverManager.getConnection("url","userName","password");	//----localhost
		Connection conn =
		DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","chris","123456");
		
		System.out.println(conn);
		//��ӡ����
		System.out.println(conn.getClass().getName());
		
	}
}
