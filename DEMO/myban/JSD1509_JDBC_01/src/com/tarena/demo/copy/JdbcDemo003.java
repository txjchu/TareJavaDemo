package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ��ʾ��ʹ��JDBC�������û���Ϣ����insert���
 * @author Administrator
 *
 */
public class JdbcDemo003 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String passWord = "123456";
		//1.��������
		Class.forName(driverName);
		//2.��ȡ����
		Connection conn = DriverManager.getConnection(url, userName, passWord);
		//3.��ȡ������
		Statement stmt = conn.createStatement();
		String sql = 
//						"INSERT INTO t_user_lc values(1002, 'LS');" +
//						"INSERT INTO t_user_lc VALUES(1003, 'ZHANG');" +
//						"INSERT INTO t_user_lc VALUES(1004, 'WANG');" +
						"INSERT INTO t_user_lc VALUES(1005, 'LI')";//����DML���
		//4.ִ��SQL
		int dml =  stmt.executeUpdate(sql);
		System.out.println("���ִ�к�Ӱ���˶��ټ�¼��"+ dml);
		
		//5.�رն���
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}












