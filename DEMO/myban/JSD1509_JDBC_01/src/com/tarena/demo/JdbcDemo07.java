package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ʾ��Statement
 * @author Administrator
 *
 */
public class JdbcDemo07 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,userName,password);//----�����˽ӿڶ���
		
		Statement stmt = conn.createStatement();	//----
		String sql = "SELECT id,name FROM t_user";
		
//		stmt.executeUpdate(sql);//----executeUpdate������Ӧ��SQL����ɾ��
		
		/**
		 * ��ס������ResultSet �̶��Ĵ���ʽ
		 * 
		 */
		
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("���\t����");
		while(rs.next()){				//----����������
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+"\t"+name);
		}
		
		//�ƶ�ָ�룬ָ���һ��
		//��ȡÿһ���ֶε�ֵ
		int id = rs.getInt("id");
		String name = rs.getString("name");
		
		System.out.println("���\t����");
		System.out.println(id+"\t"+name);
		
//		rs.next();
//		id = rs.getInt("id");
//		name = rs.getString("name");
		
		
		//�ͷ���Դ
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}	
