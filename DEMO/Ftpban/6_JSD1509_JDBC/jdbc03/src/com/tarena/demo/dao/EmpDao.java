package com.tarena.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

public class EmpDao {
	
	public void save(Emp emp){
		String sql
		= "insert into emp values(empseq.nextval,?,?,?,?,?,?,?)";
		//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ʵ����
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//װ�ز���
			pstmt.setString(1,emp.getEname());
			pstmt.setString(2,emp.getJob());
			pstmt.setInt(3,emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());
			pstmt.setDouble(5,emp.getSal());
			pstmt.setDouble(6,emp.getComm());
			pstmt.setInt(7,emp.getDeptNo());
			//ִ��insert
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,pstmt,conn);
		}
	}
	public void delete(Integer empNo){
		String sql
		= "delete from emp where empno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,empNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,pstmt,conn);
		}
	}
	public void update(Emp emp){
		String sql
		= "update emp set ename=?," +
		"job=?,mgr=?,hiredate=?," +
		"sal=?,comm=?,deptno=?" +
		" where empno=?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//װ�ز���
			pstmt.setString(1,emp.getEname());
			pstmt.setString(2,emp.getJob());
			pstmt.setInt(3,emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());
			pstmt.setDouble(5,emp.getSal());
			pstmt.setDouble(6,emp.getComm());
			pstmt.setInt(7,emp.getDeptNo());
			pstmt.setInt(8,emp.getEmpNo());
			//ִ��SQL
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,pstmt,conn);
		}
	}
	public Emp findByEmpNo(Integer empNo){
		String sql
		= "select empno,ename," +
		"job,mgr,sal,comm,hiredate," +
		"deptno from emp where empno=?";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,empNo);
			//executeQuery() ִ��select ���
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp = empMapper(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs,pstmt,conn);
		}
		return emp;
	}
	public List<Emp> findAll(){
		String sql
		= "select empno,ename," +
		"job,mgr,sal,comm,hiredate," +
		"deptno from emp";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> empList
		= new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Emp emp = empMapper(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return empList;
	}
	public Emp empMapper(ResultSet rs)
	throws SQLException{
		Emp emp = new Emp();
		emp.setEmpNo(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getDouble("sal"));
		emp.setComm(rs.getDouble("comm"));
		emp.setDeptNo(rs.getInt("deptno"));
		emp.setHiredate(rs.getDate("hiredate"));
		emp.setJob(rs.getString("job"));
		emp.setMgr(rs.getInt("mgr"));
		return emp;
	}
	//����ʵ��
	//����1����ѯĳ�������й�����ߵ�Ա����Ϣ
	/*
	 * select * from emp 
	 * where sal = 
	 * (select max(sal) from emp
	 * where deptno=?)
	 * 
	 */
	//����2����ѯԱ����Ϣ�Լ�Ա�����ڵĲ�����Ϣ��˼����
	// ����  3000 CLERK  Sales ����
	/*
	 * select ename,sal,job,dname,loc
	 * from emp e left join dept d
	 * on e.deptno=d.deptno
	 * 
	 * ����һ���µ�ʵ���� Dept :deptNo,dname,loc
	 * 
	 * Emp
	 *  Dept dept;
	 * Dept
	 * List<Emp>
	 * 
	 */
	
	
	
	
	
	
}










