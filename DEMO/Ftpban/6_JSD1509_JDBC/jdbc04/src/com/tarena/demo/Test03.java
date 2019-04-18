package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tarena.demo.util.JdbcUtil;

public class Test03 {

	/**
	 * ��ʾ��JDBC������
	 */
	public static void main(String[] args) {
		
		//testInsert();
		//��������ɾ��
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
	//�������
	public static void testInsert(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int count = 1290;
			for(int i=1;i<=count;i++){
				String sql
				= "insert into emp(empno,ename) values(empseq.nextval,'Ա��"+i+"')";
				//���SQL�������������б���
				stmt.addBatch(sql);
				if(i%200==0){
					//ִ������б��е����
					stmt.executeBatch();
					//�������б��е����
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
	//������ʵ������ɾ��
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





