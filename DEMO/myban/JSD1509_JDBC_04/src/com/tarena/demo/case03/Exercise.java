package com.tarena.demo.case03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tare.dao.EmpDao;
import com.tarena.demo.entity.Dept;
import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * 课后练习
 * @author Administrator
 *
 */
public class Exercise {
	
	//习题1：JDBC事务控制
	@Test
	public void testUpdateByDeptno(){		
		updateByDeptno(10);
	}
	//按部门更新员工工资的方法
	public static void updateByDeptno(int deptno){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//关闭自动提交事务
			String sql1 = "update emp set sal = sal * 1.2 where job = ? and deptno = "+ deptno;
			ps = conn.prepareStatement(sql1);
			ps.setString(1, "ANALYST");
			ps.executeUpdate();
			String sql2 = "update emp set sal = sal * 1.3 where job = ? and deptno = "+ deptno;
			ps = conn.prepareStatement(sql2);
			ps.setString(1, "MANAGER");
			ps.executeUpdate();
			
			
			conn.commit();//提交事务
			conn.setAutoCommit(true);//恢复自动提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {//事务回滚
				e1.printStackTrace();
				System.out.println("事务提交失败");
			}
			e.printStackTrace();
			throw new RuntimeException("按部门更新员工工资方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	//习题2：批量增加记录
	@Test	
	public void testBatchAdd(){
		batchAdd();
	}
	//向数据库dept表中批量添加记录
	public static void batchAdd(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//关闭自动更新
			stmt = conn.createStatement();
			for(int i = 0; i < 100; i ++){
				String sql = "insert into dept(deptno, dname) values(deptseq.nextval, '部门"+ i +"')";
				stmt.addBatch(sql);
				if(i % 50 == 0){
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			stmt.executeBatch();
			stmt.clearBatch();
			conn.commit();//提交
			conn.setAutoCommit(true);//恢复自动更新
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("数据回滚异常！");
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("连接数据库异常！", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}

	//习题3：关联插入，返回主键练习
	@Test
	public void testAddTeam(){
		List<Emp> emps = new ArrayList<Emp>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Emp emp1=new Emp();
        emp1.setEname("tom");
        emp1.setJob("manager");
        emp1.setMgr(7839);
        emp1.setSal(5000);
        emp1.setComm(300);
        emp1.setDeptno(30);
        
        Emp emp2=new Emp();
        emp2.setEname("marry");
        emp2.setJob("clerk");
        emp2.setMgr(1);
        emp2.setSal(2000);
        emp2.setDeptno(30);
        
        Emp emp3=new Emp();
        emp3.setEname("terry");
        emp3.setJob("salesman");
        emp3.setMgr(1);
        emp3.setSal(2500);
        emp3.setComm(200);
        emp3.setDeptno(30);
        
        Emp emp4=new Emp();
        emp4.setEname("jim");
        emp4.setJob("salesman");
        emp4.setMgr(1);
        try {
        	emp1.setHiredate(new java.sql.Date(sdf.parse("2014-05-01").getTime()));
        	emp2.setHiredate(new java.sql.Date(sdf.parse("2014-05-28").getTime()));
        	emp3.setHiredate(new java.sql.Date(sdf.parse("2014-05-29").getTime()));
			emp4.setHiredate(new java.sql.Date(sdf.parse("2014-05-26").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("日期转换异常！");
		}
        emp4.setSal(2500);
        emp4.setComm(200);
        emp4.setDeptno(30);
        
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        emps.add(emp4);
        
        addTeam(emps);
	}
	//向数据库中emp表中一次添加一组员工的方法--关联插入（练习返回主键操作）
	public static void addTeam(List<Emp> emps){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empseq.nextval, ?, ?, ?, TO_DATE(?, 'yyyy-mm-dd'), ?, ?, ?)";
			ps = conn.prepareStatement(sql, new String[]{"empno"});
			int mgr = 0;
			for(int i = 0; i < emps.size(); i++){
				Emp emp = emps.get(i);
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getJob());
				if(i == 0){
					ps.setInt(3, emp.getMgr());
				} else {
					ps.setInt(3, mgr);
				}
				ps.setString(4, emp.getHiredate().toString());//因为在SQL语句中使用了TO_DATE函数，因此，这里需要传入String类型
				ps.setDouble(5, emp.getSal());
				ps.setDouble(6, emp.getComm());
				ps.setInt(7, emp.getDeptno());
				ps.executeUpdate();//执行SQL
				if(i == 0){
					rs = ps.getGeneratedKeys();//将主键放入结果集
					if(rs.next()){
						mgr = rs.getInt(1);//获取emps中第一个元素的empno，即第一个元素是该组员工的管理者.						
					}
				}				
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (IndexOutOfBoundsException e){
			System.out.println("数组下标越界异常！");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("事务处理回滚异常！");
			}			
			e.printStackTrace();
			throw new RuntimeException("连接数据库异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}				
	}

	//习题4：测试对Dept进行分页查询的方法
	@Test
	public void testFindByPage(){
		findByPage(1, 16);
	}
	//对Dept进行分页查询的方法--练习JDBC中的分页查询
	public static void findByPage(int page, int pageSize){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql_total = "select count(*) from emp";
			int maxPage = 0;
			int total = -1;//用于辅助计算总页数
			ps = conn.prepareStatement(sql_total);
			rs = ps.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			//计算最大页数
			int n = total % pageSize;
			if(n == 0){
				maxPage = total / pageSize;
			} else {
				maxPage = total / pageSize + 1;
			}
			if(page < 1){
				page = 1;//当给定的页数小于1，则页数等于1，即显示首页。
			}else if(page > maxPage){
				page = maxPage;//当给定的页数大于最大页数，则显示最后一页。即页数等于最大页。
			}
			int begin = (page - 1) * pageSize + 1;
			int end = page * pageSize;
			String sql = "select * from (select rownum rn, deptno, dname, loc from dept order by deptno) where rn between ? and ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				System.out.println(dept);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("连接数据库异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
}















