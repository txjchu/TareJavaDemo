package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ��ʾ����������
 * ���󣺸����û���ID �޸��û�������
 * 
 * @author Administrator
 *
 */
public class JdbcDemo004 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		//1.��������
		Class.forName(driverName);
		//2.��������
		Connection conn = DriverManager.getConnection(url, userName, password);
		//3.��ȡ����SQL��������
		Statement stmt = conn.createStatement();
		String sql = "update t_user_lc SET name = 'lisi' WHERE id = 1002";
		//4.ִ��SQL
		int i = stmt.executeUpdate(sql);
		System.out.println("SQLִ�к�Ӱ��ļ�¼������"+ i);
		//5.�ͷ���Դ
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}













