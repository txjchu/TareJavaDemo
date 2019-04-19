package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *  演示：查询
 *  ResultSet
 * @author Administrator
 *
 */
public class JdbcDemo006 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		String sql = "select * from t_user_lc";
		ResultSet rs = stmt.executeQuery(sql);
		//移动指针，指向第一条
		boolean flag = rs.next();
		System.out.println("是否有记录："+ flag);
		//获取每一个字段的值
		int id = rs.getInt("id");
		String name = rs.getString("name");
		System.out.println("编号\t姓名");
		System.out.println(id +"\t"+ name);
		
		flag = rs.next();//再来一次
		System.out.println("是否有记录："+ flag);
		
		//释放资源
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}












