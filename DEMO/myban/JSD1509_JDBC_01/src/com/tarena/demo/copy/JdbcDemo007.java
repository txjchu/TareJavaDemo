package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ��ʾ����ѯ
 * ���������
 * @author Administrator
 *
 */
public class JdbcDemo007 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//��������
		Connection conn = DriverManager.getConnection(url, userName, password);//��ȡ����
		Statement stmt = conn.createStatement();//��������SQL���Ķ���
		String sql = "select id, name from t_user_lc";
		ResultSet rs = stmt.executeQuery(sql);//ִ��SQL����ȡ�����
		//��ס������ResultSet�Ĺ̶�����ʽ
		System.out.println("���\t����");
		while(rs.next()){
//			System.out.print(rs.getInt("id"));
//			System.out.print("\t");
//			System.out.println(rs.getString("name"));
//			System.out.println("-------");
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id +"\t"+ name);
		}
		//�ͷ���Դ
		if(rs != null){
			rs.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}













