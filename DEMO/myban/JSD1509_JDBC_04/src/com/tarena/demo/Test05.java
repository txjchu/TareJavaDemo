package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * 测试：Oracle分页
 * 
 * 1.分页
 * 2.末页			总记录数/pageSize+1
 *
 */
public class Test05 {
	public static void main(String[] args) {
		
		int page = 1;
		int pageSize = 3;
		
		List<Emp> empList = findByPage(page,pageSize);
		
		for(Emp e: empList){
			System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t");//------
		}
		
	}
	public static List<Emp> findByPage(int page,int pageSize){
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "select *from (select rownum rn,empno,ename from emp_zyl) where rn between ? and ? ";
		
		int begin = (page-1)*pageSize+1;
		int end = page*pageSize;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}	
		return empList;
	}
	//计算最大页数
	public static int maxPage(int pageSize){
		int max=0;
		String sql = "select count(*) from emp_zyl";
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			//获取记录数
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, stmt, conn);
		}
		//pageSize5	 50  10
		//		  5	 52  11
		
		max = count%pageSize == 0? count/pageSize : count/pageSize+1;
		return max;
	}
	
	
}
