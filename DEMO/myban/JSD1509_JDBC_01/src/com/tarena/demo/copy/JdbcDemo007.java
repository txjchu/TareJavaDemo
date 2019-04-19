package com.tarena.demo.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 演示：查询
 * 迭代结果集
 * @author Administrator
 *
 */
public class JdbcDemo007 {
	public static void main(String[] args) throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "chris";
		String password = "123456";
		Class.forName(driverName);//加载驱动
		Connection conn = DriverManager.getConnection(url, userName, password);//获取连接
		Statement stmt = conn.createStatement();//创建处理SQL语句的对象
		String sql = "select id, name from t_user_lc";
		ResultSet rs = stmt.executeQuery(sql);//执行SQL，获取结果集
		//记住：处理ResultSet的固定处理方式
		System.out.println("编号\t姓名");
		while(rs.next()){
//			System.out.print(rs.getInt("id"));
//			System.out.print("\t");
//			System.out.println(rs.getString("name"));
//			System.out.println("-------");
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id +"\t"+ name);
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













