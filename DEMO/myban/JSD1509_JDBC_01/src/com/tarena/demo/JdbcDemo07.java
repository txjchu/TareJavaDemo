package com.tarena.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 演示：Statement
 * @author Administrator
 *
 */
public class JdbcDemo07 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,userName,password);//----创建了接口对象
		
		Statement stmt = conn.createStatement();	//----
		String sql = "SELECT id,name FROM t_user";
		
//		stmt.executeUpdate(sql);//----executeUpdate方法的应用SQL的增删改
		
		/**
		 * 记住：处理ResultSet 固定的处理方式
		 * 
		 */
		
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("编号\t姓名");
		while(rs.next()){				//----创建迭代器
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+"\t"+name);
		}
		
		//移动指针，指向第一条
		//获取每一个字段的值
		int id = rs.getInt("id");
		String name = rs.getString("name");
		
		System.out.println("编号\t姓名");
		System.out.println(id+"\t"+name);
		
//		rs.next();
//		id = rs.getInt("id");
//		name = rs.getString("name");
		
		
		//释放资源
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}	
