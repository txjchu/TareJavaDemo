package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *  ��ʾ����ѯ
 *  ResultSet
 * @author Administrator
 *
 */
public class JdbcDemo006 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		String sql = "select * from t_user_lc";
		ResultSet rs = stmt.executeQuery(sql);
		//�ƶ�ָ�룬ָ���һ��
		boolean flag = rs.next();
		System.out.println("�Ƿ��м�¼��"+ flag);
		//��ȡÿһ���ֶε�ֵ
		int id = rs.getInt("id");
		String name = rs.getString("name");
		System.out.println("���\t����");
		System.out.println(id +"\t"+ name);
		
		flag = rs.next();//����һ��
		System.out.println("�Ƿ��м�¼��"+ flag);
		
		//�ͷ���Դ
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}












