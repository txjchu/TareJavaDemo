package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * 测试可滚动结果集
 * @author Administrator
 *
 */
public class Test001 {
	
	@Test	//测试可滚动结果集
	public void test01(){
		String sql = "select empno, ename, sal from emp";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//设置可滚动结果集参数，可滚动，不敏感，只读
			rs = stmt.executeQuery(sql);
			
			//指向第五条
			rs.absolute(5);
			System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename"));
			//向前滚动一条
			rs.previous();
			System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename"));
						
/*			
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEname(rs.getString("ename"));
				emp.setEmpNo(rs.getInt("empno"));
				emp.setSal(rs.getDouble("sal"));
				emps.add(emp);
			}
*/			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("测试方法1异常！", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);			
		}
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	
	@Test	//演示JDBC事务处理
	public void test02(){
		int outId = 8820;
		int inId = 8815;
		double money = 1000;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			//1.先关闭自动提交	设置自动提交方式为false
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//2.执行SQL语句	转出，转入
			String outSql = "update emp set sal = sal - "+ money +" where empno = "+ outId;
			stmt.executeUpdate(outSql);
			String inSql = "update emp set sal = sal +"+ money +" where empno = "+ inId;
			stmt.executeUpdate(inSql);
			//3.提交事务		
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//回滚	若提交失败
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("演示JDBC事务处理方法异常！", e);
		} finally {
			//4.还原自动提交事务
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			JdbcUtil.close(null, stmt, conn);
		}
	}
	@Test	//按员工编号查询员工信息
	public void testFindByEmpno(){
		String sql = "select empno, ename, job, sal, comm from emp where empno = ?";
		Integer empno = 3002;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emp.setJob(rs.getString("job"));
				emp.setComm(rs.getDouble("comm"));
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("测试查询员工信息方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	@Test	//测试批量处理数据的方法
	public void test03(){
//		insertByBatch();
		int[] empnos = new int[200];//定义数组长度100
		int empno = 3401;
		for(int i = 0; i < empnos.length; i++){//给数组赋值
			empnos[i] = empno;
			empno ++;
		}
		System.out.println(Arrays.toString(empnos));
		deleteByBatch(empnos);
	}
	//批量处理删除语句
	public static void deleteByBatch(int[] empnos){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno = ?";
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			int count = 0;
			for(int empno : empnos){
				ps.setInt(1, empno);
				ps.addBatch();
				count ++;
				if(count % (empnos.length / 5) == 0){//当有1/5的empno时，执行一次，防止内存溢出
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			ps.clearParameters();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("批量删除语句方法异常！", e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
	}
	//批量处理插入语句
	public static void insertByBatch(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int count = 300;
			for(int i = 0; i < count; i++){
				String sql = "insert into emp(empno, ename) values(empseq.nextval, '员工"+ i % 100 +"')"; 
				stmt.addBatch(sql);
				if(i % 200 == 0){//防止OutOfMemory内存溢出
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			//最后不足200条时
			stmt.executeBatch();
			stmt.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("批量处理插入语句方法异常！", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}		
	}
	
	@Test	//演示JDBC中向数据库多张关联表中添加数据时，保护数据的关联性。
	public void test04(){
		//1.插入主表的SQL，使用个序列作为主键
		String sql1 = "insert into dept values(deptseq.nextval, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//2.定义stmt时，第二个参数是设置GeneratedKeys方法获取主键的字段名列表。类型是字符串数组。
			ps = conn.prepareStatement(sql1, new String[]{"deptno"});
			ps.setString(1, "开发部");
			ps.setString(2, "西安");
			//3.执行SQL
			ps.executeUpdate();//向dept表中添加记录
			//4.获取主键值
			rs = ps.getGeneratedKeys();
			rs.next();//移动结果集的指针
			int deptno = rs.getInt(1);//结果集当前记录的第一列的数据
			String sql2 = "insert into emp(empno, ename, deptno) values (empseq.nextval, ?, ?)";
			//5.将获取到的主键值，作为外键插入到表中。
			ps = conn.prepareStatement(sql2);//预编译SQL
			ps.setString(1, "李雷");//向emp表中添加记录
			ps.setInt(2, deptno);
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("关联插入数据方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}		
	}
	
	/*
	 * 分页查询
	 * Oracle 中分页查询使用Rownum
	 * MySQL中使用
	 * Select empno, ename, job From emp Limit begin, pageSize; 
	 */
	@Test
	public void test05(){
		//emp表中共有20条记录
		int maxPage = maxPage(6);
		System.out.println(maxPage);
		System.out.println(maxPage(5));
		System.out.println(maxPage(8));
		List<Emp> emps = new ArrayList<Emp>();
		emps = findByPage(4, 5);//若是页数大于表中分页的最大页数的话，则没有任何记录可以显示。
		System.out.println("empno\tename\tsal");
		for(Emp e : emps){
			System.out.println(e.getEmpno() +"\t"+ e.getEname() +"\t"+ e.getSal() );
		}
		
		
	}
	public static List<Emp> findByPage(int page, int pageSize){
		String sql = "select * from (select rownum rn, empno, ename, sal from emp) where rn between ? and ?";
		int begin = (page - 1) * pageSize + 1;
		int end = page * pageSize;
		List<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询方法异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emps;
	}
	//计算最大页数
	public static int maxPage(int pageSize){
		String sql = "select count(*) from emp";
		int maxPage = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();//-----------不要忘记调用rs.next()移动结果集的指针
			int count = rs.getInt(1);
			int n = count / pageSize; 
			if(count % pageSize == 0){
				maxPage = n;
			} else {
				maxPage = n + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询最大页数异常", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return maxPage;
		
	}


	@Test
	public void test(){
		System.out.println(tryCatch());
	}
	//try-catch-finally语句的流程
	public static int tryCatch(){
		int b = 20;
		try {
			System.out.println("try block");
			return b += 80;
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
			if( b > 25){
				System.out.println("b > 25, b = "+ b);
			}
			b = 150;
		}
		return 2000;
		
	}

	
	
}













