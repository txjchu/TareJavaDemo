package com.tarena.demo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import demo.JdbcUtil;

/**
 * 演示：PreparedStatement(一）
 * sql注入现象，以及处理SQL注入现象
 *
 */
public class UserDao {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		while(true){
			
			System.out.print("请输入用户帐号：");
			String userName = sc.next();
			System.out.print("请输入用户密码：");
			String password = sc.next();		//----nextLine()可以包含特殊字符
			if(find1(userName,password)){  		//----【find/find1两个接口测试】
				break;
			}
			System.out.println("用户名或密码错误！");
		}
		System.out.println("登录成功！");
	}
	//需求：根据用户名和密码查询数据是否存在
	public static boolean find(String userName,String password){
		String sql = "select id,userName,password FROM t_account WHERE userName = '"+userName+"' and password='"+password+"'";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return false;
	
	}		
		
		
		
		
		
	//测试PreparedStatement 用法
	public static boolean find1(String userName,String password){
		
		String sql = "select id,username,password from t_account "+
						"where username=? and password=?";
		
		//定义
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		//赋值，实例化
		try {
			conn = JdbcUtil.getConnection();	//----连接对象
			//实例化语句对象的时候就使用sql，实例化时就预处理SQL语句。
			pstmt = conn.prepareStatement(sql);	//----语句对象-----
			//装载参数
//			pstmt = setXXX();		//----
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			//执行SQL
			rs = pstmt.executeQuery();		//----里面不传sql参数。
			
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}
		
		
		return false;
	}
		
		
	
	
	
	
	
}