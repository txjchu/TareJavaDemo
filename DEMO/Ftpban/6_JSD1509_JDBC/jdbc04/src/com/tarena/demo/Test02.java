package com.tarena.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

public class Test02 {

	/**
	 * 演示JDBC事务处理
	 */
	public static void main(String[] args) {
		
		int outId = 1001;
		int inId = 1002;
		double money = 1000;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//设置自动提交方式为false
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//转出
			String outSql
			= "update t_account set money=money-"
			+money+" where id="+outId;
			stmt.executeUpdate(outSql);
			//转入
			String inSql
			= "update t_account set money=money+"
			+money+" where id="+inId;
			stmt.executeUpdate(inSql);
			
			
			//提交
			conn.commit();
		} catch (SQLException e) {
			//回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				//恢复自动提交方式
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JdbcUtil.close(null,stmt,conn);
		}
	}
}
