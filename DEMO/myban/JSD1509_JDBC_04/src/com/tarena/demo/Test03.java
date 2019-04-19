package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tarena.demo.util.JdbcUtil;

/**
 * 演示：JDBC批处理
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//----测试批量添加
		testInsert();
		//测试批处理删除
		int[] empNos = new int[30];
		int empNo = 2030;
		for(int i=0;i<empNos.length;i++){
			empNos[i] = empNo;
			empNo +=5;
			
		}
		System.out.println(Arrays.toString(empNos));//----Arrary提供的API，可以将数组的内容转换为字符串。
		deleteByEmpNos(empNos);
	}
	//批量添加
	public static void testInsert(){
		//添加两个对象，连接对象和语句对象
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			
			stmt = conn.createStatement();
			int count = 1290; //----
			for(int i=1;i<=count;i++){//----循环一次，将要添加的SQL语句假如到数据中。
				String sql ="insert into emp_zyl(empno,ename) values(empseq.nextval,'员工"+i+"')";
				//----通过该语句对象，将SQL语句添加到语句列表里
				stmt.addBatch(sql);
				if(i%200==0){
					//执行语句列表中的语句
					stmt.executeBatch();//----每200次
					//清空语句列表中的语句
					stmt.clearBatch();
				}
				
			}
			stmt.executeBatch();//-----以防遗漏
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
			//----sql和pstmt 放到for外面，放在循环中出现问题。因为会循环创建语句对象，不断覆盖赋值。？
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
