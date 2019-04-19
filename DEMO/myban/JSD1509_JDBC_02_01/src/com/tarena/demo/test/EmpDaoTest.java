package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.JdbcUtil;

/**
 * 演示：使用JDBC工具类，查询所有员工信息
 *
 */
public class EmpDaoTest {
	
	public static void main(String[] args) {
	findAll();
	}
	
	public static void findAll(){
		String sql = "select empno,ename,hiredate,sal,deptno from emp_zyl";
		
		
		//套路
		//1.定义		----先定义，方法中的变量是局部变量
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2.实例化
		try {
			conn = JdbcUtil.getConnection();		//----抛出异常，先加try...catch...
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		//2.5查询处理结果集。增删改没有结果集，固定的处理方式
			System.out.println("编号\t姓名\t入职日期\t薪水\t部门号");
			
			while(rs.next()){
				System.out.println(rs.getInt("empno")+"\t"+
								   rs.getString("ename")+"\t"+
								   //Java里面有两种DATE类型，java.sql.Date类型，是java.util.Date的子类
								   rs.getDate("hiredate")+"\t"+
								   rs.getDouble("sal")+"\t"+
								   rs.getInt("deptno")
								   );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//3.释放资源
			JdbcUtil.close(rs, stmt, conn);
		}
	
	}
	
}
