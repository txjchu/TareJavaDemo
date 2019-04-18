package com.tarena.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

public class Test01 {

	/**
	 * ���Կɹ��������
	 */
	public static void main(String[] args) {
		
		String sql
		= "select empno,ename,sal from emp";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//ͨ���������󣬻�ȡ�Ľ�����ɹ���	concurrency
			stmt
			= conn.createStatement
			(ResultSet.TYPE_SCROLL_INSENSITIVE
			,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			//ָ�������
			rs.absolute(5);
			System.out.println
			(rs.getInt("empno")+"\t"
			+rs.getString("ename"));
			//��ǰ����һ��
			rs.previous();
			System.out.println
			(rs.getInt("empno")+"\t"
			+rs.getString("ename"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
	}
}
