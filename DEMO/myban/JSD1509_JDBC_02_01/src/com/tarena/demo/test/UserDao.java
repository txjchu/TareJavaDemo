package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import demo.JdbcUtil;

/**
 * ��ʾ��PreparedStatement(һ��
 * sqlע�������Լ�����SQLע������
 *
 */
public class UserDao {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		while(true){
			
			System.out.print("�������û��ʺţ�");
			String userName = sc.next();
			System.out.print("�������û����룺");
			String password = sc.next();		//----nextLine()���԰��������ַ�
			if(find1(userName,password)){  		//----��find/find1�����ӿڲ��ԡ�
				break;
			}
			System.out.println("�û������������");
		}
		System.out.println("��¼�ɹ���");
	}
	//���󣺸����û����������ѯ�����Ƿ����
	public static boolean find(String userName,String password){
		String sql = "select id,userName,password FROM t_account WHERE userName = '"+userName+"' and password='"+password+"'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return false;
	
	}		
		
		
		
		
		
	//����PreparedStatement �÷�
	public static boolean find1(String userName,String password){
		
		String sql = "select id,username,password from t_account "+
						"where username=? and password=?";
		
		//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		//��ֵ��ʵ����
		try {
			conn = JdbcUtil.getConnection();	//----���Ӷ���
			//ʵ�����������ʱ���ʹ��sql��ʵ����ʱ��Ԥ����SQL��䡣
			pstmt = conn.prepareStatement(sql);	//----������-----
			//װ�ز���
//			pstmt = setXXX();		//----
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			//ִ��SQL
			rs = pstmt.executeQuery();		//----���治��sql������
			
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}
		
		
		return false;
	}
		
		
	
	
	
	
	
}