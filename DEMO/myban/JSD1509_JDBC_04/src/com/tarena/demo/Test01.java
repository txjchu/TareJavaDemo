package com.tarena.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

/**
 * ���ԣ��ɹ����Ľ����
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String sql = "select empno,ename from emp_zyl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtil.getConnection();
			//ͨ���������󣬻�ȡ�Ľ�������Թ���
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery(sql);
			
			rs.absolute(5);//----ֱ��ָ�������
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
			
			//----��ǰ����
			rs.previous();
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		
	}
}
