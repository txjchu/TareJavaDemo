package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarena.demo.util.JdbcUtil;

/**
 * ��ʾ����������
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) {
		
		String sql1 = "insert into dept_zyl values(deptseq.nextval,?,?)";
		String sql2 = "insert into emp_zyl (empno,ename,deptno) values(empseq.nextval,?,?)";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = JdbcUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql1,new String[]{"deptno"});//----???
			pstmt.setString(1, "�з���");
			pstmt.setString(2, "��ַ");
			pstmt.executeUpdate();
			
			//��ȡ���ɵ�����ֵ
			rs = pstmt.getGeneratedKeys();
			rs.next();
			int deptNo = rs.getInt(1);//----getInt(1)???
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, "zsf");
			pstmt.setInt(2, deptNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}
		
		
	}
}
