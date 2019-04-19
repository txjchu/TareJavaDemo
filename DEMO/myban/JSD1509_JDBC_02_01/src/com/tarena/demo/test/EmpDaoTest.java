package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.JdbcUtil;

/**
 * ��ʾ��ʹ��JDBC�����࣬��ѯ����Ա����Ϣ
 *
 */
public class EmpDaoTest {
	
	public static void main(String[] args) {
	findAll();
	}
	
	public static void findAll(){
		String sql = "select empno,ename,hiredate,sal,deptno from emp_zyl";
		
		
		//��·
		//1.����		----�ȶ��壬�����еı����Ǿֲ�����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2.ʵ����
		try {
			conn = JdbcUtil.getConnection();		//----�׳��쳣���ȼ�try...catch...
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		//2.5��ѯ������������ɾ��û�н�������̶��Ĵ���ʽ
			System.out.println("���\t����\t��ְ����\tнˮ\t���ź�");
			
			while(rs.next()){
				System.out.println(rs.getInt("empno")+"\t"+
								   rs.getString("ename")+"\t"+
								   //Java����������DATE���ͣ�java.sql.Date���ͣ���java.util.Date������
								   rs.getDate("hiredate")+"\t"+
								   rs.getDouble("sal")+"\t"+
								   rs.getInt("deptno")
								   );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//3.�ͷ���Դ
			JdbcUtil.close(rs, stmt, conn);
		}
	
	}
	
}
