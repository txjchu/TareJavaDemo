package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.JdbcUtil01;

/**
 * ����JdbcUtil01��������÷�
 * 
 * ��ʾ����ѯ����Ա������Ϣ��
 * @author Administrator
 *
 */
public class EmpDaoTest01 {
	public static void main(String[] args) {
		findAll();
	}
	
	//��ѯ������Ϣ�ķ���
	public static void findAll(){
		String sql = "select empno, ename, hiredate, sal, deptno from emp";
		//1.����
		Connection conn = null;//���Ӷ���
		Statement stmt = null;//������
		ResultSet rs = null;//���շ��ؼ�����
		//2.ʵ����
		try{
			conn = JdbcUtil01.getConnection();//��ȡ����
			stmt = conn.createStatement();//ʵ����������
			rs = stmt.executeQuery(sql);//ִ��SQL��䣬�����շ��ؼ�
			//�������ؼ�
			System.out.println("���\t����\t��ְ����\t\tнˮ\t���ź�");
			while(rs.next()){
				System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename") +"\t"+
						//java.sql.Date����java.util.Date������
						rs.getDate("hiredate") +"\t"+ rs.getDouble("sal") +"\t"+
						rs.getInt("deptno"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//3.�ͷ���Դ
			JdbcUtil01.close(rs, stmt, conn);
		}
	}
}












