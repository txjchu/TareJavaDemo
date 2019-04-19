package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import demo.DBUtilByPool;

/**
 * ʹ��DBUtilByPool���ݿ��̳߳ع����ഴ�����ӣ��������ݿ��ȡ���ݡ�
 * @author Administrator
 *
 */
public class EmpDao02 {
	public static void main(String[] args) {
		EmpDao02 ed = new EmpDao02();
		ed.findAll();
	}
	
	/*
	 * ��ȡ���ݵķ���
	 */
	public void findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs  = null;
		try {
			conn = DBUtilByPool.getConnection();
			stmt = conn.createStatement();
			String sql = "select empno, ename, job, sal, deptno, mgr from emp";
			rs = stmt.executeQuery(sql);
			System.out.println("empno\tename\tjob\tsal\tdeptno\tmgr");
			while(rs.next()){
				System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename") +"\t"+
							rs.getString("job") +"\t"+ rs.getDouble("sal") +"\t"+ rs.getInt("deptno") +"\t"+ rs.getInt("mgr"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtilByPool.close(rs, stmt, conn);
		}
		
	}
}














