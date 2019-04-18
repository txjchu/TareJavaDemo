package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.tarena.demo.util.JdbcUtil;

public class UserDao {

	/**
	 * 演示：PreparedStatement（一）
	 * sql注入现象，以及处理SQL注入现象
	 */
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("用户账号：");
			String userName = sc.nextLine();
			System.out.print("用户密码：");
			String password = sc.nextLine();
			if(find1(userName,password)){
				break;
			}
			System.out.println("用户名或密码错误：");
		}
		System.out.println("登录成功！。。。");
	}
	//需求：根据用户名和密码查询数据是否存在
	public static boolean find
	(String userName,String password){
		String sql
		= "select id,username,password" +
		" from t_account where username='"
		+userName+"' and password='"
		+password+"'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return false;
	}
	
	//测试PreparedStatement用法
	public static boolean find1
	(String userName,String password){
		
		String sql
		= "select id,username,password" +
		" from t_account" +
		" where username=?" +
		" and password=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = JdbcUtil.getConnection();
			//实例化   预处理SQL语句
			pstmt = conn.prepareStatement(sql);
			//装载参数
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			//执行SQL	
			rs = pstmt.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs,pstmt,conn);
		}
		return false;
	}
}









