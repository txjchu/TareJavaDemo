package com.tarena.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

/**
 * 演示JDBC事务处理
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//----第一次在一个SQL语句里发送2条？
		
		int outId = 1001;
		int inId = 1002;
		double money = 1000;
		
		Connection conn = null;
		Statement stmt = null; 	//----和Statement的区别
		
		try {
			conn = JdbcUtil.getConnection();

			//设置自动提交方式为false
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();//----创建语句对象
			
			//转出以及转出SQL，pstmt
			String outsql = "update t_account set money=money-"+money+" where id="+outId;
			stmt.executeUpdate(outsql);
			
//			pstmt = conn.prepareStatement(outsql);
//			pstmt.setDouble(1, money);
//			pstmt.setInt(2,outId);
//			pstmt.executeUpdate();
			
//			System.out.println(10/0);//----测试出现错误的情况（不执行下面部分代码，进入catch语句）
			
			//转入
			String insql = "update t_accoun t set money = money+"+money+" where id="+inId;
			stmt.executeUpdate(insql);
			
//			pstmt = conn.prepareStatement(insql);
//			pstmt.setDouble(1, money);
//			pstmt.setInt(2, inId);
//			pstmt.executeUpdate();//----
			
			//提交
			conn.commit();
			
		} catch (SQLException e) {
			
			//回滚
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
				//恢复自动提交方式
				conn.setAutoCommit(true);
			}catch(SQLException e){
				e.printStackTrace();
//				throw new RuntimeException();
			}
			
			JdbcUtil.close(null,stmt,conn);
		}
				
		
		
		
		
	}
}
