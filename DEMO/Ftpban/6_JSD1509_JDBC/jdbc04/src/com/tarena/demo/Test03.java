package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tarena.demo.util.JdbcUtil;

public class Test03 {

	/**
	 * 演示：JDBC批处理
	 */
	public static void main(String[] args) {
		
		//testInsert();
		//测试批量删除
		int[] empNos = new int[30];
		int empNo = 2100;
		for(int i=0;i<empNos.length;i++){
			empNos[i] = empNo;
			empNo+=5;
		}
		System.out.println
		(Arrays.toString(empNos));
		deleteByEmpNos(empNos);
	}
	//批量添加
	public static void testInsert(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int count = 1290;
			for(int i=1;i<=count;i++){
				String sql
				= "insert into emp(empno,ename) values(empseq.nextval,'员工"+i+"')";
				//添加SQL到语句对象的语句列表中
				stmt.addBatch(sql);
				if(i%200==0){
					//执行语句列表中的语句
					stmt.executeBatch();
					//清空语句列表中的语句
					stmt.clearBatch();
				}
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null, stmt, conn);
		}
	}
	//批处理实现批量删除
	public static void deleteByEmpNos(int[] empNos){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql
			= "delete from emp where empno=?";
			pstmt
			= conn.prepareStatement(sql);
			for(int empNo : empNos){
				pstmt.setInt(1, empNo);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			pstmt.clearBatch();		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}
		
		
	}

}





