package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 需求1.使用Java 应用程序模拟实现创建新的部门
 * 部门名称：A部门（用户输入）
 * 部门地址：北京海淀（用户输入）
 * 
 * 分析：
 * 1.实现模拟界面，
 * 2.获取用户的输入，
 * 3.使用JDBC 执行添加数据的操作。
 * 
 * 
 */
public class JdbcDemo08 {
	/**
	 * 需求：模拟系统添加数据的操作
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * 独立实现：每次添加成功之后，再显示所有部门信息
	 * 
	 * 要求：独立定义查询的方法，打印数据功能在该方法中实现。
	 * 
	 */
		private static Connection conn;//----定义一个静态变量，放在main外
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("部门名称：");
		String dname = sc.next();
		System.out.print("部门地址：");
		String loc = sc.next();	
	
		saveDept(dname,loc);	//----保存数据到表里面
		
		findAll( dname,loc);	//----在这个方法中实现对部门表的查询和打印

		//测试“+dname+”
//		String str1 = "abc";
//		String str2 = "def";
//		String str3 = "gh";
//		
//		String str = "----"+str1+"----";
//		String str4 = "===="+str2+"====";
//		String str5 = "===='"+str3+"'====";//-----????
//		
	}
	
	
	
	public static void saveDept(String dname,String loc) throws ClassNotFoundException, SQLException{	//----定义一个方法，有两个要素：类型，参数（以及方法的名）
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		//1.加载驱动，建立连接
		
		Class.forName(driverName);
		conn = DriverManager.getConnection(url,userName,password);
		
		//2.创建语句对象，执行insert （DML,DDL）语句
		Statement stmt = conn.createStatement();
		String sql = "insert INTO t_dept VALUES(seq.nextval,'"+dname+"','"+loc+"')";	//----序列，
		
		stmt.executeUpdate(sql);//----
		
//		rs.getInt("")+"\t"+
//		rs.getInt("")+"\t"+
		
	}
	
	private static void findAll(String dname,String loc) throws SQLException{
		Statement stmt = conn.createStatement();	//----发送语句
		String sql = "SELECT dname,loc FROM t_dept";//----
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("部门名称"+"\t"+"部门地址");
		while(rs.next()){
			System.out.println(rs.getString("dname")+"\t"+rs.getString("loc"));
		}
		//3.释放资源----从保存数据的方法放到输出数据方法里面
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
