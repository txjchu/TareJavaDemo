package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 演示：删除数据
 * 需求：根据用户的ID，删除用户信息
 * @author Administrator
 *
 */
public class JdbcDemo005 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//1.加载驱动
		Connection conn = DriverManager.getConnection(url, userName, password);//2.获取连接
		Statement stmt = conn.createStatement();//3.获取处理SQL语句对象
		String sql = "delete from t_user_lc where id = 1002";
		int i = stmt.executeUpdate(sql);//4.执行SQL
		System.out.println("影响记录数："+ i);
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
		
	}
}












