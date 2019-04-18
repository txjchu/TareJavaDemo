package com.tarena.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

public class Test02 {

	/**
	 * ��ʾJDBC������
	 */
	public static void main(String[] args) {
		
		int outId = 1001;
		int inId = 1002;
		double money = 1000;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//�����Զ��ύ��ʽΪfalse
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//ת��
			String outSql
			= "update t_account set money=money-"
			+money+" where id="+outId;
			stmt.executeUpdate(outSql);
			//ת��
			String inSql
			= "update t_account set money=money+"
			+money+" where id="+inId;
			stmt.executeUpdate(inSql);
			
			
			//�ύ
			conn.commit();
		} catch (SQLException e) {
			//�ع�
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				//�ָ��Զ��ύ��ʽ
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JdbcUtil.close(null,stmt,conn);
		}
	}
}
