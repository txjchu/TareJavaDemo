package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo08 {

	/**
	 * ����ģ��ϵͳ��������ݵĲ���
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * ����ʵ�֣�ÿ����ӳɹ�֮������ʾ����
	 * ������Ϣ
	 * 
	 * Ҫ��:���������ѯ�ķ���,
	 *     ��ӡ���ݹ����ڸ÷�����ʵ��
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������ƣ�");
		String dname = sc.next();
		System.out.print("���ŵ�ַ:");
		String loc = sc.next();
		saveDept(dname,loc);
	}
	public static void saveDept
	(String dname,String loc)
	throws ClassNotFoundException
	, SQLException{
		String driverName
		= "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:"
				+ "@192.168."
				+ "201.220:1521:orcl";
		String userName = "openlab";
		String password = "open123";
		//1��������������������
		Class.forName(driverName);
		Connection conn
		= DriverManager.
		getConnection(url,userName,password);		
		//2������������ִ��insert ���
		Statement stmt 
		= conn.createStatement();
		String sql
		= "insert into t_dept_lc values(seq_lc.nextval,'"+dname+"','"+loc+"') ";
		stmt.executeUpdate(sql);
		//3���ͷ���Դ
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
	

}
