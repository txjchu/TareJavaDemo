package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.JdbcUtil01;

/**
 * 测试JdbcUtil01工具类的用法
 * 
 * 演示：查询所有员工的信息。
 * @author Administrator
 *
 */
public class EmpDaoTest01 {
	public static void main(String[] args) {
		findAll();
	}
	
	//查询所有信息的方法
	public static void findAll(){
		String sql = "select empno, ename, hiredate, sal, deptno from emp";
		//1.定义
		Connection conn = null;//连接对象
		Statement stmt = null;//语句对象
		ResultSet rs = null;//接收返回集集合
		//2.实例化
		try{
			conn = JdbcUtil01.getConnection();//获取连接
			stmt = conn.createStatement();//实例化语句对象
			rs = stmt.executeQuery(sql);//执行SQL语句，并接收返回集
			//遍历返回集
			System.out.println("编号\t姓名\t入职日期\t\t薪水\t部门号");
			while(rs.next()){
				System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename") +"\t"+
						//java.sql.Date类是java.util.Date的子类
						rs.getDate("hiredate") +"\t"+ rs.getDouble("sal") +"\t"+
						rs.getInt("deptno"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//3.释放资源
			JdbcUtil01.close(rs, stmt, conn);
		}
	}
}












