package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ��ʾ��ɾ������
 * ���󣺸����û���ID��ɾ���û���Ϣ
 * @author Administrator
 *
 */
public class JdbcDemo005 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//1.��������
		Connection conn = DriverManager.getConnection(url, userName, password);//2.��ȡ����
		Statement stmt = conn.createStatement();//3.��ȡ����SQL������
		String sql = "delete from t_user_lc where id = 1002";
		int i = stmt.executeUpdate(sql);//4.ִ��SQL
		System.out.println("Ӱ���¼����"+ i);
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
		
	}
}












