package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import demo.DBUtilByPool;

/**
 * ¿ÎºóÏ°Ìâ
 * @author Administrator
 *
 */
public class DeptDao {
	public static void main(String[] args) {
		DeptDao dd = new DeptDao();
		dd.findAll();
	}
	
	public void findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtilByPool.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			System.out.println("deptno\tdname\tloc");
			while(rs.next()){
				System.out.println(rs.getInt("deptno") +"\t"+ rs.getString("dname") +"\t"+ rs.getString("loc"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtilByPool.close(rs, stmt, conn);
		}
		
	}
}
