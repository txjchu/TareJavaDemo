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
 * dept���DAO
 * @author Administrator
 *
 */
public class DeptDao {
	/*
	 * ���������ݿ������Ӽ�¼dept
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
			System.out.println("���������쳣��");
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;
	}
	/*
	 * ɾ��ɾ���������ű�ŵĲ�����Ϣ
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
			throw new RuntimeException("ɾ������dept�쳣��", e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
		return false;
	}
	
	/*
	 * �ģ����ո�����dept�����޸����ݿ���е�����
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
			throw new RuntimeException("���·����쳣��", e);
		} finally {
			JdbcUtil.close(null, ps, conn);			
		}
		return false;
	}
	/*
	 * �飺��ѯ���еĲ�����Ϣ
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
			while(rs.next()){//��ָ���ƶ�����һ����¼��
				Dept dept = deptMapper(rs);//��ȡ������¼�б����������Ϣ
				depts.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ���м�¼�����쳣!", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return depts;
	}
	/*
	 * �飺���ո����Ĳ��ű�ţ���ѯ���ݿ�dept���е���ؼ�¼
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
			throw new RuntimeException("�����ű�Ų�ѯdept�����쳣��", e);
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














