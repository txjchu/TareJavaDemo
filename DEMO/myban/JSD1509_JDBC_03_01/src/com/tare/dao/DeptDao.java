package com.tare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tare.entity.Dept;
import com.tare.util.JdbcUtil;

/**
 * dept表的DAO
 * @author Administrator
 *
 */
public class DeptDao {
	/*
	 * 增：向数据库表中添加记录dept
	 */
	public boolean add(Dept dept){
		String sql = "insert into dept(deptno, dname, loc) values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			flag = ps.executeUpdate();
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("创建连接异常！");
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;
	}
	/*
	 * 删：删除给定部门编号的部门信息
	 */
	public boolean delete(Integer deptno){
		String sql = "delete from dept where deptno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			flag = ps.executeUpdate();
			if(flag != 0){
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除数据dept异常！", e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
		return false;
	}
	
	/*
	 * 改：按照给定的dept对象修改数据库表中的数据
	 */
	public boolean update(Dept dept){
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			ps.setInt(3, dept.getDeptno());
			flag = ps.executeUpdate();
			if(flag != 0){
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新方法异常！", e);
		} finally {
			JdbcUtil.close(null, ps, conn);			
		}
		return false;
	}
	/*
	 * 查：查询所有的部门信息
	 */
	public List<Dept> findAll(){
		String sql = "select deptno, dname, loc from dept";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Dept> depts = new ArrayList<Dept>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){//将指针移动到下一条记录上
				Dept dept = deptMapper(rs);//获取该条记录中保存的数据信息
				depts.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有记录方法异常!", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return depts;
	}
	/*
	 * 查：按照给定的部门编号，查询数据库dept表中的相关记录
	 */
	public Dept findByDeptno(Integer deptno){
		String sql = "select deptno, dname, loc from dept where deptno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dept dept = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			while(rs.next()){
				dept = deptMapper(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("按部门编号查询dept方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return dept;
	}
	
	public static Dept deptMapper(ResultSet rs) throws SQLException{
		Dept dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		return dept;
	}
}














