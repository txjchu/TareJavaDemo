package com.tarena.demo.case03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * day03的案例
 * @author Administrator
 *
 */
public class Case01 {
	
	//案例1：JDBC的事务控制
	@Test	
	public void test01(){
		transfer("A", "B", 500.3);
	}
	//转账方法
	public static void transfer(String from, String to, double amount){
		String sql1 = "update account set amount = amount - "+ amount +" where id = '"+ from +"'";
		String sql2 = "update account set amount = amount + "+ amount +" where id = '" + to +"'";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//设置不自动提交事务
			stmt.execute(sql1);//执行SQL
			stmt.execute(sql2);
			conn.commit();//提交事务
			conn.setAutoCommit(true);//设置回自动提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("事务回滚异常", e);
			}
			e.printStackTrace();
			throw new RuntimeException("数据库访问异常！", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}
	
	//案例2：JDBC中批量处理SQL语句
	@Test 	
	public void test02(){
		batchAdd();
	}
	//批量处理向数据库表中插入数据的SQL语句的方法
	public static void batchAdd(){
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//关闭自动提交事务
			int n = 0;
			for(int i = 0; i < 100; i ++){
				n = (int) (Math.random() * 100000);//随机生成（0.0~1.0）*100000之间的数
				String sql = "insert into emp(empno, ename, sal) values(empseq.nextval, '员工"+ i +"', "+ n +")";
				stmt.addBatch(sql);//将sql语句提交到批量处理批次总
				if(i % 50 == 0){
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			stmt.executeBatch();//将最后一次批次总的SQL语句执行
			stmt.clearBatch();//清空批次
			conn.commit();//提交事务
			conn.setAutoCommit(true);//开启自动提交事务
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("连接数据库异常！", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}		
	}
	
	//案例3：返回主键，关联插入，保证插入数据的关联性。
	@Test	
	public void testAddEmp(){
		addEmp();
	}
	//关联插入数据
	public static void addEmp(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//关闭自动提交事务
			String sql = "insert into dept values(deptseq.nextval, ?, ?)";//向主表中插入数据
			ps = conn.prepareStatement(sql, new String[]{"deptno"});//执行SQL
			ps.setString(1, "Research");
			ps.setString(2, "无锡");
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();//通过语句处理对象获取主键内容，并放入结果集中
			rs.next();//移动指针
			int deptno = rs.getInt(1);//获取结果集中当前记录的内容
			String sql1 = "insert into emp(empno, ename, sal, deptno) values(empseq.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(sql1);//通过连接对象，再次与数据库交互，并产生新的处理语句对象
			ps.setString(1, "泡泡");
			ps.setDouble(2, 6666.7);
			ps.setInt(3, deptno);
			ps.executeUpdate();//执行sql
						
			conn.commit();//提交事务
			conn.setAutoCommit(true);//开启自动提交事务
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("连接数据库异常！", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	//案例4：分页查询
	@Test
	public void testFindByPageOracle(){
		System.out.println("进入测试！");
		findByPageOracle(14, 8);
	}
	//JDBC中Oracle数据库的分页查询
	public void findByPageOracle(int page, int pageSize){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			//先确定最大页数
			int maxPage = -1;
			String sql = "select count(*) from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();//不要忘记移动结果集中的指针
			int count = rs.getInt(1);//获取emp表中记录总数
			int n = count / pageSize;
			if(count % pageSize == 0 ){
				maxPage = n;
			} else {
				maxPage = n + 1;
			}
			System.out.println("emp表中共有"+ count +"条记录，共有"+ maxPage +"页（每页"+ pageSize +"条记录）");
			if(page > maxPage){//若传入的页数大于最大页数，则页数等于最大页数，即显示最后一页
				page = maxPage;
			}
			if(page < 1){//若page小于1，则显示第一页内容
				page = 1;
			}
			int begin = (page - 1) * pageSize + 1;
			int end = page * pageSize;
			String sql1 = "select * from (select rownum rn, empno, ename, job, sal, deptno from (select * from emp order by empno)) where rn between "+ begin +"and "+ end ; 
			ps = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			System.out.println("empno\tename\tjob\tsal\tdeptno");
			while(rs.next()){//移动结果集指针
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				emps.add(emp);
			}
			for(Emp e : emps){
				System.out.println(e.getEmpno() +"\t"+ e.getEname() +"\t"+ e.getJob() +"\t"+ e.getSal() +"\t"+ e.getDeptno());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库访问异常", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}	
	
}













