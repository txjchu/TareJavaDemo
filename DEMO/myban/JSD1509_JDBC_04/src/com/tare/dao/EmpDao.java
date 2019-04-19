package com.tare.dao;

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

/**
 * Dao Data Access Object 数据访问对象
 * EmpDao实现ORM(Object/Relation Mapping)对象关系映射-java中的对象和数据库关系表相互映射。
 * 
 * @author Administrator
 *
 */
public class EmpDao {
	/**
	 * 完成对象与数据库之间的增删改查操作。
	 */
	/*
	 * 增：保存Emp对象
	 */
	public boolean add(Emp emp){
		String sql = "insert into emp values(empseq.nextval, ?, ?, ?, ?, ?, ?, ?)";//定义预编译SQL语句
		//定义
		Connection conn = null;//创建连接对象
		PreparedStatement ps = null;//创建预编译语句对象
		int flag = 0;//语句对象更新数据的方法返回是影响的记录数
		//实例化
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//装载参数
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			//执行insert
//			ps.executeUpdate();
			flag = ps.executeUpdate();//获取是否成功
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接对象异常！");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;
	}
	/*
	 * 删：按员工编号删除数据库表中的数据
	 */
	public boolean delete(Integer empno){
		String sql = "delete from emp where empno = ?";
		//定义
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			flag = ps.executeUpdate();//若删除成功则返回影响的记录数
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接对象异常");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
		return false;
	}
	/*
	 * 改：修改数据库表中的记录
	 */
	public boolean update(Emp emp){
		String sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?," +
				" sal = ?, comm = ?, deptno = ? where empno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			flag = ps.executeUpdate();
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接对象失败！");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;//若中间出异常了，则不会执行出异常语句后面的代码。因此应该放到try-catch-finally语句后。
	}
	/*
	 * 查：1.通过员工编号查出员工信息
	 */
	public Emp findByEmpno(Integer empNo){
		String sql = "select empno, ename, job, mgr, sal, comm, hiredate, deptno from emp where empno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;//接收从数据库中传过来的结果集数据
		Emp emp = null;//用来将结果集转变为实体类的具体对象
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			rs = ps.executeQuery();
			while(rs.next()){
				emp = empMapper(rs);//将结果集中的数据赋值给Emp对象
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建连接异常！");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emp;
	}
	/*
	 * 对象与数据库表中数据映射的方法
	 * 该方法将结果集中的一条记录转换为一个Emp对象。ORM(Object/Relation Mapping)
	 */
	public Emp empMapper(ResultSet rs) throws SQLException{
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getDouble("sal"));
		emp.setComm(rs.getDouble("comm"));
		emp.setDeptno(rs.getInt("deptno"));
		emp.setHiredate(rs.getDate("hiredate"));
		//怎样将获取列值变为可判断的，自由赋值列值到对象的成员属性上，而不是限制个数性的赋值。
			emp.setMgr(rs.getInt("mgr"));			
		
		emp.setJob(rs.getString("job"));	
		
		return emp;
	}
	/*
	 * 查：2.查出所有的员工信息
	 */
	public List<Emp> findAll(){
		String sql = "select empno, ename, job, mgr, sal, comm, hiredate, deptno from emp";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();//用于接收转换过来的Emp对象
//		List<Emp> emps = null;	//java.lang.NullPointerException空指针异常
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Emp emp = empMapper(rs);//将结果集中的当前记录转换为Emp对象
				emps.add(emp);//将Emp对象添加到集合中
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接异常！");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return emps;
	}	
	/*
	 * 根据员工姓名查询员工信息
	 */
	public List<Emp> findByEname(String ename){
		String sql = "select empno, ename, job, sal, comm, deptno, mgr, hiredate from emp where ename = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = empMapper(rs);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询指定姓名的员工信息异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);			
		}
		return emps;		
	}
	/*
	 * 需求1：查询某个部门中工资最高的员工信息。
	 * select * from emp where sal = (select max(sal) from emp where deptno = ?)
	 * 
	 * 需求2：查询员工信息以及员工所在的部门信息
	 * select ename, sal, job, deptno, dname, loc from emp e left join dept d
	 * on e.deptno = d.deptno
	 */
	
	/*
	 * 需求1：查询某个部门中工资最高的员工信息
	 */
	public List<Emp> findByDeptno(Integer deptno){
		String sql = "select * from emp where sal = (select Max(sal) from emp where deptno = ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = empMapper(rs);
				emps.add(emp);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询部门中最高工资员工信息方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);			
		}
		return emps;
	}
	/*
	 * 需求2：查询员工信息，包含所在的部门信息
	 */
	public List<Emp> findEmpWithDemp(){
		String sql = "select e.empno, e.ename, e.job, e.sal, e.comm, e.mgr, e.hiredate, d.deptno, d.dname, d.loc from emp e left join dept d on e.deptno = d.deptno";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Dept dept = DeptDao.deptMapper(rs);
				Emp emp = empMapper(rs);
				emp.setDept(dept);//将dept对象放入emp对象中
				emps.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询包含部门信息的员工信息方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emps;
	}
	
	
}










