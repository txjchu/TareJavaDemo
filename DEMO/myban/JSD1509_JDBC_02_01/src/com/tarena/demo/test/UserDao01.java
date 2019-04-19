package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import demo.JdbcUtil;
import demo.JdbcUtil01;

/**
 * 演示：PreparedStatement(一)
 * SQL注入现象，以及处理SQL注入现象
 * @author Administrator
 *
 */
public class UserDao01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入用户名：");
			String userName = scan.nextLine();
			System.out.println("请输入密码：");
			String password = scan.nextLine();
			if(find1(userName, password)){	//【find和find1两个方法都要测试】
				break;
			}
			System.out.println("用户名或密码错误！");
		}
		System.out.println("登录成功...");

	}
	
	//Statement的用法，不防范SQL的注入
	public static boolean find(String userName, String password){
		String sql = "select account_id, login_name, login_passwd from account where login_name = '"+
						userName +"' and login_passwd = '"+ password +"'";
		System.out.println(sql);
		
		Connection conn = null;//获取连接
		Statement stmt = null;//语句对象
		ResultSet rs = null;//结果集对象
		try {
			conn = JdbcUtil01.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return false;
	}
	//PreparedStatement 的用法，防止SQL的注入
	public static boolean find1(String name, String password){
		String sql = "select account_id, login_name, login_passwd from account where" +
						" login_name = ? and login_passwd = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil01.getConnection();
			ps = conn.prepareStatement(sql);//预装载SQL语句
			ps.setString(1, name);//装载参数
			ps.setString(2, password);
			System.out.println(sql);//装载完后sql语句还是预装载时的样子。不会增添参数。
			rs = ps.executeQuery();//执行SQL
			while(rs.next()){//此处是用while语句还是用if语句
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return false;
	}
}











