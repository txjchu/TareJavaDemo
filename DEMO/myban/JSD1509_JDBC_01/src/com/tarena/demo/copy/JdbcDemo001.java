package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ��ʾ�������������򣬴������Ӷ���
 * @author Administrator
 *
 */
public class JdbcDemo001 {
	public static void main(String[] args) throws Exception {
		//������������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//��ȡ�����ݿ������
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
//				"jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456"
		System.out.println(conn);
		//��ӡ����������conn�Ƿ񴴽��ɹ�
		System.out.println(conn.getClass().getName());
		System.out.println("�Ƿ����ӳɹ�");
	}
}












