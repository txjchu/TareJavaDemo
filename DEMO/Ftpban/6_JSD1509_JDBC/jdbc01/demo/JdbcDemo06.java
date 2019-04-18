package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ʾ��ѯ
 * 
 */

public class JdbcDemo06 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:"
				+ "@192.168."
				+ "201.220:1521:orcl";
		String userName = "openlab";
		String password = "open123";
		
		Class.forName(driverName);
		
		Connection conn
		= DriverManager.getConnection
		(url,userName,password);
		
		Statement stmt
		= conn.createStatement();
		
		String sql
		= "select id,name from t_user_lc";
		
		ResultSet rs = 
		stmt.executeQuery(sql);
		//�ƶ�ָ�룬ָ���һ��
		boolean flag = rs.next();
		System.out.println(flag);//true
		//��ȡÿһ���ֶε�ֵ
		int id = rs.getInt("id");
		String name = rs.getString("name");
		System.out.println("���\t����");
		System.out.println(id+"\t"+name);
		
		rs.next();//true
		id = rs.getInt("id");
		name = rs.getString("name");
		System.out.println(id+"\t"+name);
		
		flag = rs.next();
		System.out.println(flag);//false
		
		//�ͷ���Դ
		if(rs!=null){
			rs.close();
		}
		if(conn!=null){
			conn.close();
		}
		

	}

}
