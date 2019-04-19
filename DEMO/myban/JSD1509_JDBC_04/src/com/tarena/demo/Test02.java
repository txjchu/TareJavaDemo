package com.tarena.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

/**
 * ��ʾJDBC������
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//----��һ����һ��SQL����﷢��2����
		
		int outId = 1001;
		int inId = 1002;
		double money = 1000;
		
		Connection conn = null;
		Statement stmt = null; 	//----��Statement������
		
		try {
			conn = JdbcUtil.getConnection();

			//�����Զ��ύ��ʽΪfalse
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();//----����������
			
			//ת���Լ�ת��SQL��pstmt
			String outsql = "update t_account set money=money-"+money+" where id="+outId;
			stmt.executeUpdate(outsql);
			
//			pstmt = conn.prepareStatement(outsql);
//			pstmt.setDouble(1, money);
//			pstmt.setInt(2,outId);
//			pstmt.executeUpdate();
			
//			System.out.println(10/0);//----���Գ��ִ�����������ִ�����沿�ִ��룬����catch��䣩
			
			//ת��
			String insql = "update t_accoun t set money = money+"+money+" where id="+inId;
			stmt.executeUpdate(insql);
			
//			pstmt = conn.prepareStatement(insql);
//			pstmt.setDouble(1, money);
//			pstmt.setInt(2, inId);
//			pstmt.executeUpdate();//----
			
			//�ύ
			conn.commit();
			
		} catch (SQLException e) {
			
			//�ع�
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
//				throw new RuntimeException(e1);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try{
				//�ָ��Զ��ύ��ʽ
				conn.setAutoCommit(true);
			}catch(SQLException e){
				e.printStackTrace();
//				throw new RuntimeException();
			}
			
			JdbcUtil.close(null,stmt,conn);
		}
				
		
		
		
		
	}
}
