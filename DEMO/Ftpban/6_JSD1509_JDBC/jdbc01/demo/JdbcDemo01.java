package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��ʾ�������������򣬴������Ӷ���
 */
public class JdbcDemo01 {

	public static void main(String[] args)
			throws ClassNotFoundException
			, SQLException {
		
		//������������
		Class.forName
		("oracle.jdbc.driver.OracleDriver");
		
		//��ȡ�����ݿ������
		Connection conn
		= DriverManager.getConnection
		("jdbc:oracle:thin:@192.168.201.220:1521:orcl",
		"openlab","open123");
		
		System.out.println(conn);
		//��ӡ����
		System.out.println
		(conn.getClass().getName());
	}
}
