package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ����1.ʹ��Java Ӧ�ó���ģ��ʵ�ִ����µĲ���
 * �������ƣ�A���ţ��û����룩
 * ���ŵ�ַ�����������û����룩
 * 
 * ������
 * 1.ʵ��ģ����棬
 * 2.��ȡ�û������룬
 * 3.ʹ��JDBC ִ��������ݵĲ�����
 * 
 * 
 */
public class JdbcDemo08 {
	/**
	 * ����ģ��ϵͳ������ݵĲ���
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * ����ʵ�֣�ÿ����ӳɹ�֮������ʾ���в�����Ϣ
	 * 
	 * Ҫ�󣺶��������ѯ�ķ�������ӡ���ݹ����ڸ÷�����ʵ�֡�
	 * 
	 */
		private static Connection conn;//----����һ����̬����������main��
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�������ƣ�");
		String dname = sc.next();
		System.out.print("���ŵ�ַ��");
		String loc = sc.next();	
	
		saveDept(dname,loc);	//----�������ݵ�������
		
		findAll( dname,loc);	//----�����������ʵ�ֶԲ��ű�Ĳ�ѯ�ʹ�ӡ

		//���ԡ�+dname+��
//		String str1 = "abc";
//		String str2 = "def";
//		String str3 = "gh";
//		
//		String str = "----"+str1+"----";
//		String str4 = "===="+str2+"====";
//		String str5 = "===='"+str3+"'====";//-----????
//		
	}
	
	
	
	public static void saveDept(String dname,String loc) throws ClassNotFoundException, SQLException{	//----����һ��������������Ҫ�أ����ͣ��������Լ�����������
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		//1.������������������
		
		Class.forName(driverName);
		conn = DriverManager.getConnection(url,userName,password);
		
		//2.����������ִ��insert ��DML,DDL�����
		Statement stmt = conn.createStatement();
		String sql = "insert INTO t_dept VALUES(seq.nextval,'"+dname+"','"+loc+"')";	//----���У�
		
		stmt.executeUpdate(sql);//----
		
//		rs.getInt("")+"\t"+
//		rs.getInt("")+"\t"+
		
	}
	
	private static void findAll(String dname,String loc) throws SQLException{
		Statement stmt = conn.createStatement();	//----�������
		String sql = "SELECT dname,loc FROM t_dept";//----
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("��������"+"\t"+"���ŵ�ַ");
		while(rs.next()){
			System.out.println(rs.getString("dname")+"\t"+rs.getString("loc"));
		}
		//3.�ͷ���Դ----�ӱ������ݵķ����ŵ�������ݷ�������
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
