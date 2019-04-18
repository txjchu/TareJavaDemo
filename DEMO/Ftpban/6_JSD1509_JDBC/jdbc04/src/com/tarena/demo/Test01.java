package com.tarena.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

public class Test01 {

	/**
	 * 测试可滚动结果集
	 */
	public static void main(String[] args) {
		
		String sql
		= "select empno,ename,sal from emp";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//通过该语句对象，获取的结果集可滚动	concurrency
			stmt
			= conn.createStatement
			(ResultSet.TYPE_SCROLL_INSENSITIVE
			,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			//指向第五条
			rs.absolute(5);
			System.out.println
			(rs.getInt("empno")+"\t"
			+rs.getString("ename"));
			//向前滚动一条
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
