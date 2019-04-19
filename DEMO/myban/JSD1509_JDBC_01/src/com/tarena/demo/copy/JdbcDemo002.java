package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ��ʾ������������ʹ�������󣬷���DDL
 * �������ṩ�����ݿⷢ��SQL��API
 * @author Administrator
 *
 */
public class JdbcDemo002 {
	public static void main(String[] args) throws Exception {
		//1.������������������
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String passWord = "123456";
		Connection conn = DriverManager.getConnection(url, userName, passWord);
		System.out.println("�Ƿ����ӣ�"+ conn.getClass().getName());
		
		//2.����������ִ��SQL���
		Statement stmt = conn.createStatement();
		String sql = "create table t_user_lc(id number(4) primary key, name varchar2(20))";
		//ִ��DDL���
		boolean flag = stmt.execute(sql);
		System.out.println(flag);
		//3.�ͷ���Դ���ر������󣬹ر����Ӷ���
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}











