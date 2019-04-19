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

//Dao对数据操作的方法一般保存为Dao
/**
 * DAO封装对数据的访问.DAO (Data Access Object)
 */
public class EmpDao {
	/**
	 * 增：向数据库表中增加一条Emp对象对应的记录。
	 * @param emp
	 */
	public void save(Emp emp){
		
		String sql = "insert into emp_zyl values(empseq.nextval,?,?,?,?,?,?,?)";//----添加select语句----【emp_zyl?】
		//定义
		Connection conn = null;
		PreparedStatement pstmt = null;
		//实例化
		try {
			
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//----赋值的时候一定要注意每一个字段的类型
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());//----utilDate--->String--->java.sql.Date???
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			//执行insert
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(null,pstmt,conn);
		}
	}
	
	/**
	 * *删除职员信息，
	 * 
	 */
	public void delete(Integer empNo){
		String sql = "delete from emp_zyl where empno=?";//----删除SQL语句
		
		//套路
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			
			pstmt.executeUpdate();//----生成try...catch
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}
	}
	
	/**
	 * *更新职员信息，（修改）
	 */
	
	public void update(Emp emp){
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?,where empno=?";//----修改SQL语句
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JdbcUtil.getConnection();//----自动生成try...catch
			
			pstmt = conn.prepareStatement(sql);//----?
			
			//装载参数
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setDate(4,emp.getHiredate());
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			pstmt.setInt(8,emp.getEmpNo());
			
			//执行SQL
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
	 * 查询某个职员信息。
	 * 
	 * select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp_zyl where empno=?
	 * 返回：empno,ename,sal,comm,hiredate,sal,comm,deptno ----对象
	 */
	public Emp findByEmpNo(Integer empNo){
		String sql = "select empno,ename,job,mgr,sal,comm,hiredate,deptno from emp_zyl where empno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Emp emp = null;//-----声明一个emp对象
		
		try {
			conn=JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			//executeQuery()执行select语句
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp = new Emp();
				
				//把值放到emp里
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
	 * 查询所有职员信息，
	 * select *from emp_zyl;
	 */
	
	public List<Emp> findAll(){
		String sql = "select empno,ename,job,mgr,sal,comm,hiredate,deptno from emp_zyl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Emp> empList = new ArrayList<Emp>();//----构建一个emp放到Emp集合里，查询出来一条就放一条，【循环】
		
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
	
	
	//需求：查询某个部门中的员工信息
	
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
	 * 独立实现：
	 * 
	 * 1.需求：查询某个部门中工资最高的员工信息。
	 * select *from emp_zyl
	 * where sal=
	 * (select max(sal) from emp_zyl where deptno=?)
	 *  
	 * 2.需求：查询员工信息以及员工所在的部门信息(思考)
	 * select ename ,sal,job,dname,loc 
	 * from emp_zyl e left join dept_zyl d 【内链接，外连接，左连接，外连接】【为了以防少数据】 
	 * on e.deptno=d.deptno ;
	 * 
	 * 【要满足需求需要创建一个新的实体类Dept:deptNo,dname,loc】
	 * Emp
	 * 	Dept dept
	 * Dept
	 *  List<Emp>
	 * 
	 */
	
	public  List<Emp> findEmpDept(){
		List<Emp> empList = new ArrayList<Emp> ();		//-----泛型，少个括号，方法的调用
		
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
				emp.setDept(dept);		//----将一个dept对象放入emp对象中。
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
