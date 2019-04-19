package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tarena.demo.util.JdbcUtil;

/**
 * ��ʾ��JDBC������
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//----�����������
		testInsert();
		//����������ɾ��
		int[] empNos = new int[30];
		int empNo = 2030;
		for(int i=0;i<empNos.length;i++){
			empNos[i] = empNo;
			empNo +=5;
			
		}
		System.out.println(Arrays.toString(empNos));//----Arrary�ṩ��API�����Խ����������ת��Ϊ�ַ�����
		deleteByEmpNos(empNos);
	}
	//�������
	public static void testInsert(){
		//��������������Ӷ����������
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			
			stmt = conn.createStatement();
			int count = 1290; //----
			for(int i=1;i<=count;i++){//----ѭ��һ�Σ���Ҫ��ӵ�SQL�����絽�����С�
				String sql ="insert into emp_zyl(empno,ename) values(empseq.nextval,'Ա��"+i+"')";
				//----ͨ���������󣬽�SQL�����ӵ�����б���
				stmt.addBatch(sql);
				if(i%200==0){
					//ִ������б��е����
					stmt.executeBatch();//----ÿ200��
					//�������б��е����
					stmt.clearBatch();
				}
				
			}
			stmt.executeBatch();//-----�Է���©
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,stmt,conn);
		}
	}
	
	public static void deleteByEmpNos(int[] empNos){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn=JdbcUtil.getConnection();
			//----sql��pstmt �ŵ�for���棬����ѭ���г������⡣��Ϊ��ѭ�����������󣬲��ϸ��Ǹ�ֵ����
			String sql = "delete from emp_zyl where empno=?";	
			pstmt = conn.prepareStatement(sql);//----preparedStatement???
			for(int empNo:empNos){
				pstmt.setInt(1, empNo);
				pstmt.addBatch();
					
			}
			pstmt.executeBatch();//----
			pstmt.clearBatch();//-----
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}
	}
	
}
