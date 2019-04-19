package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 演示：
 * 需求：模拟系统中添加数据的操作
 * 独立实现：每次添加成功之后，再显示所有部门信息
 * 要求：独立定义查询的方法，打印数据功能在该方法中实现。
 * 
 * @author Administrator
 *	
 */
public class JdbcDemo008 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入部门名称：");
		String name = scan.nextLine();
//		System.out.println(name);
		System.out.println("请输入部门地址：");
		String loc = scan.nextLine();
//		System.out.println(loc);
		saveDept(name, loc);
		
	}
	
	//保存部门信息的方法
	public static void saveDept(String name, String loc) throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//通过Class的静态方法加载驱动
		Connection conn = DriverManager.getConnection(url, userName, password);//获取连接对象
		Statement stmt = conn.createStatement();//获取处理SQL语句的对象
		//注意：此处SQL语句的拼接中单引号和双引号。单引号是在SQL语句中包含字符型数据的，双引号是在java中拼接字符串的。
		String sql = 
			"insert into t_dept_lc values(seq_lc.nextval, '"+ name +"','"+ loc +"')";
		stmt.executeUpdate(sql);//执行DML语句
		sql = "select * from t_dept_lc";
		ResultSet rs = stmt.executeQuery(sql);//执行DQL语句，并获取结果集
		System.out.println("编号\t部门名称\t部门地址");
		while(rs.next()){
			int id = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String dloc = rs.getString("loc");
			System.out.println(id +"\t"+ dname +"\t"+ dloc);
		}
		//释放资源
		if(rs != null){
			rs.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}

	
	
	
	
	
	
	
	
	
	
	
	