package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import demo.JdbcUtil;
import demo.JdbcUtil01;

/**
 * ��ʾ��PreparedStatement(һ)
 * SQLע�������Լ�����SQLע������
 * @author Administrator
 *
 */
public class UserDao01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("�������û�����");
			String userName = scan.nextLine();
			System.out.println("���������룺");
			String password = scan.nextLine();
			if(find1(userName, password)){	//��find��find1����������Ҫ���ԡ�
				break;
			}
			System.out.println("�û������������");
		}
		System.out.println("��¼�ɹ�...");

	}
	
	//Statement���÷���������SQL��ע��
	public static boolean find(String userName, String password){
		String sql = "select account_id, login_name, login_passwd from account where login_name = '"+
						userName +"' and login_passwd = '"+ password +"'";
		System.out.println(sql);
		
		Connection conn = null;//��ȡ����
		Statement stmt = null;//������
		ResultSet rs = null;//���������
		try {
			conn = JdbcUtil01.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return false;
	}
	//PreparedStatement ���÷�����ֹSQL��ע��
	public static boolean find1(String name, String password){
		String sql = "select account_id, login_name, login_passwd from account where" +
						" login_name = ? and login_passwd = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil01.getConnection();
			ps = conn.prepareStatement(sql);//Ԥװ��SQL���
			ps.setString(1, name);//װ�ز���
			ps.setString(2, password);
			System.out.println(sql);//װ�����sql��仹��Ԥװ��ʱ�����ӡ��������������
			rs = ps.executeQuery();//ִ��SQL
			while(rs.next()){//�˴�����while��仹����if���
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return false;
	}
}











