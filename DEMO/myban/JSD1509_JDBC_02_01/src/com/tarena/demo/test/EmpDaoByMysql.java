package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试mysql连接
 * @author Administrator
 *
 */
public class EmpDaoByMysql {
	public static void main(String[] args) {
		findAll();
	}
	
	public static void findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url = "jdbc:mysql://localhost:3306/mysql";//mysql默认端口为3306
			            //jdbc:mysql://<地址>:<端口号>/<数据库名>	
			String userName = "root";
			String password = "";
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println(conn.getClass().getName());//是否获得了连接对象
			//3.创建语句对象
			String sql = "Select * from emp";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("empno\tename\tjob\tmgr\thiredate\tsal\tcomm\tdeptno");
			while(rs.next()){
				System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename") +"\t"+
						rs.getString("job") +"\t"+ rs.getInt("mgr") +"\t"+ rs.getDate("hiredate")
						 +"\t"+ rs.getDouble("sal") +"\t"+ rs.getDouble("comm") +"\t"+ rs.getInt("deptno"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}






