package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 演示：更新数据
 * 需求：根据用户的ID 修改用户的姓名
 * 
 * @author Administrator
 *
 */
public class JdbcDemo004 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		//1.加载驱动
		Class.forName(driverName);
		//2.创建连接
		Connection conn = DriverManager.getConnection(url, userName, password);
		//3.获取处理SQL的语句对象
		Statement stmt = conn.createStatement();
		String sql = "update t_user_lc SET name = 'lisi' WHERE id = 1002";
		//4.执行SQL
		int i = stmt.executeUpdate(sql);
		System.out.println("SQL执行后影响的记录数量："+ i);
		//5.释放资源
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}













