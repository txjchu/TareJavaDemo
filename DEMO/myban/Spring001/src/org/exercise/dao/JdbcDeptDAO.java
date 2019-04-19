package org.exercise.dao;

/**
 * 实现DeptDAO接口，
 * @author Administrator
 *
 */
public class JdbcDeptDAO implements DeptDAO{

	public void add() {
		System.out.println("利用JDBC技术保存Dept信息");
		
	}

	public void delete() {
		System.out.println("利用JDBC技术删除Dept信息");
		
	}

	public void update() {
		System.out.println("利用JDBC技术修改Dept信息");
		
	}
	
}
