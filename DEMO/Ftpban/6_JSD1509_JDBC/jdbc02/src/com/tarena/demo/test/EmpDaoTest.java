package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.demo.util.JdbcUtil;

public class EmpDaoTest {

	/**
	 * ��ʾ��ʹ��JDBC�����࣬��ѯ����Ա����Ϣ
	 */
	public static void main(String[] args) {
		findAll();
	}
	
	public static void findAll(){
		String sql
		= "select empno,ename," +
		  "hiredate,sal,deptno from emp";
		//1������
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2��ʵ����
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		//2.5����ѯ����������
			System.out.println("���\t����\t��ְ����\tнˮ\t���ź�");
			while(rs.next()){
				System.out.println
				(rs.getInt("empno")+"\t"+
				 rs.getString("ename")+"\t"+
				 //java.sql.Date����
				 //��java.util.Date������
				 rs.getDate("hiredate")+"\t"+
				 rs.getDouble("sal")+"\t"+
				 rs.getInt("deptno")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
		//3���ͷ���Դ
			JdbcUtil.close(rs,stmt,conn);
		}
	}

}
