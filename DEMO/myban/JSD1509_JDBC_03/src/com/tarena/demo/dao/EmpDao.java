package com.tarena.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tarena.demo.entity.Dept;
import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

//Dao�����ݲ����ķ���һ�㱣��ΪDao
/**
 * DAO��װ�����ݵķ���.DAO (Data Access Object)
 */
public class EmpDao {
	/**
	 * ���������ݿ��������һ��Emp�����Ӧ�ļ�¼��
	 * @param emp
	 */
	public void save(Emp emp){
		
		String sql = "insert into emp_zyl values(empseq.nextval,?,?,?,?,?,?,?)";//----���select���----��emp_zyl?��
		//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ʵ����
		try {
			
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//----��ֵ��ʱ��һ��Ҫע��ÿһ���ֶε�����
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());//----utilDate--->String--->java.sql.Date???
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			//ִ��insert
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,pstmt,conn);
		}
	}
	
	/**
	 * *ɾ��ְԱ��Ϣ��
	 * 
	 */
	public void delete(Integer empNo){
		String sql = "delete from emp_zyl where empno=?";//----ɾ��SQL���
		
		//��·
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			
			pstmt.executeUpdate();//----����try...catch
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}
	}
	
	/**
	 * *����ְԱ��Ϣ�����޸ģ�
	 */
	
	public void update(Emp emp){
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?,where empno=?";//----�޸�SQL���
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConnection();//----�Զ�����try...catch
			
			pstmt = conn.prepareStatement(sql);//----?
			
			//װ�ز���
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			pstmt.setInt(8,emp.getEmpNo());
			
			//ִ��SQL
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}
		}
	/**
	 * ��ѯĳ��ְԱ��Ϣ��
	 * 
	 * select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp_zyl where empno=?
	 * ���أ�empno,ename,sal,comm,hiredate,sal,comm,deptno ----����
	 */
	public Emp findByEmpNo(Integer empNo){
		String sql = "select empno,ename,job,mgr,sal,comm,hiredate,deptno from emp_zyl where empno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Emp emp = null;//-----����һ��emp����
		
		try {
			conn=JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			//executeQuery()ִ��select���
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp = new Emp();
				
				//��ֵ�ŵ�emp��
//				emp.setEmpNo(rs.getInt("empno"));
//				emp.setEname(rs.getString("ename"));
//				emp.setSal(rs.getDouble("sal"));
//				emp.setComm(rs.getDouble("comm"));
//				emp.setDeptNo(rs.getInt("deptno"));
//				emp.setHiredate(rs.getDate("hiredate"));
//				emp.setJob(rs.getString("job"));
//				emp.setMgr(rs.getInt("mgr"));
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs,pstmt,conn);
		}
		return emp;
	}
	
	/**
	 * ��ѯ����ְԱ��Ϣ��
	 * select *from emp_zyl;
	 */
	
	public List<Emp> findAll(){
		String sql = "select empno,ename,job,mgr,sal,comm,hiredate,deptno from emp_zyl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Emp> empList = new ArrayList<Emp>();//----����һ��emp�ŵ�Emp�������ѯ����һ���ͷ�һ������ѭ����
		
		try {
			conn = JdbcUtil.getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Emp emp = new Emp();
				
//				Emp emp = new empMapper(rs);
				
				emp.setEmpNo(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptNo(rs.getInt("deptno"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, stmt, conn);
		}
		return empList;
	}
	
	
	//���󣺲�ѯĳ�������е�Ա����Ϣ
	
	//
	public Emp empMapper(ResultSet rs) throws SQLException{
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
	
	/**
	 * ����ʵ�֣�
	 * 
	 * 1.���󣺲�ѯĳ�������й�����ߵ�Ա����Ϣ��
	 * select *from emp_zyl
	 * where sal=
	 * (select max(sal) from emp_zyl where deptno=?)
	 *  
	 * 2.���󣺲�ѯԱ����Ϣ�Լ�Ա�����ڵĲ�����Ϣ(˼��)
	 * select ename ,sal,job,dname,loc 
	 * from emp_zyl e left join dept_zyl d �������ӣ������ӣ������ӣ������ӡ���Ϊ���Է������ݡ� 
	 * on e.deptno=d.deptno ;
	 * 
	 * ��Ҫ����������Ҫ����һ���µ�ʵ����Dept:deptNo,dname,loc��
	 * Emp
	 * 	Dept dept
	 * Dept
	 *  List<Emp>
	 * 
	 */
	
	public  List<Emp> findEmpDept(){
		List<Emp> empList = new ArrayList<Emp> ();		//-----���ͣ��ٸ����ţ������ĵ���
		
		String sql = "select ename,sal,job,dname,loc from emp e left join dept d on e.deptno = d.deptno";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				Emp emp = new Emp();
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emp.setJob(rs.getString("job"));
				emp.setDept(dept);		//----��һ��dept�������emp�����С�
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}finally{
			JdbcUtil.close(rs, stmt, conn);
		}		
		return empList;
	}
	
}
