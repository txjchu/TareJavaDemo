package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo08 {

	/**
	 * 需求：模拟系统中添加数据的操作
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * 独立实现：每次添加成功之后，再显示所有
	 * 部门信息
	 * 
	 * 要求:独立定义查询的方法,
	 *     打印数据功能在该方法中实现
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("部门名称：");
		String dname = sc.next();
		System.out.print("部门地址:");
		String loc = sc.next();
		saveDept(dname,loc);
	}
	public static void saveDept
	(String dname,String loc)
	throws ClassNotFoundException
	, SQLException{
		String driverName
		= "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:"
				+ "@192.168."
				+ "201.220:1521:orcl";
		String userName = "openlab";
		String password = "open123";
		//1、加载驱动，建立连接
		Class.forName(driverName);
		Connection conn
		= DriverManager.
		getConnection(url,userName,password);		
		//2、创建语句对象，执行insert 语句
		Statement stmt 
		= conn.createStatement();
		String sql
		= "insert into t_dept_lc values(seq_lc.nextval,'"+dname+"','"+loc+"') ";
		stmt.executeUpdate(sql);
		//3、释放资源
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
	

}
