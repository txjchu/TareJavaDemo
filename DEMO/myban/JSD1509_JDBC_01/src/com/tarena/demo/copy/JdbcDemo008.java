package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ��ʾ��
 * ����ģ��ϵͳ��������ݵĲ���
 * ����ʵ�֣�ÿ����ӳɹ�֮������ʾ���в�����Ϣ
 * Ҫ�󣺶��������ѯ�ķ�������ӡ���ݹ����ڸ÷�����ʵ�֡�
 * 
 * @author Administrator
 *	
 */
public class JdbcDemo008 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����벿�����ƣ�");
		String name = scan.nextLine();
//		System.out.println(name);
		System.out.println("�����벿�ŵ�ַ��");
		String loc = scan.nextLine();
//		System.out.println(loc);
		saveDept(name, loc);
		
	}
	
	//���沿����Ϣ�ķ���
	public static void saveDept(String name, String loc) throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//ͨ��Class�ľ�̬������������
		Connection conn = DriverManager.getConnection(url, userName, password);//��ȡ���Ӷ���
		Statement stmt = conn.createStatement();//��ȡ����SQL���Ķ���
		//ע�⣺�˴�SQL����ƴ���е����ź�˫���š�����������SQL����а����ַ������ݵģ�˫��������java��ƴ���ַ����ġ�
		String sql = 
			"insert into t_dept_lc values(seq_lc.nextval, '"+ name +"','"+ loc +"')";
		stmt.executeUpdate(sql);//ִ��DML���
		sql = "select * from t_dept_lc";
		ResultSet rs = stmt.executeQuery(sql);//ִ��DQL��䣬����ȡ�����
		System.out.println("���\t��������\t���ŵ�ַ");
		while(rs.next()){
			int id = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String dloc = rs.getString("loc");
			System.out.println(id +"\t"+ dname +"\t"+ dloc);
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

	
	
	
	
	
	
	
	
	
	
	
	