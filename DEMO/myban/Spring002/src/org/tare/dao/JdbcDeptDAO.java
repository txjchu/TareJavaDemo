package org.tare.dao;

import org.springframework.stereotype.Repository;

@Repository		//持久层组件注解
public class JdbcDeptDAO implements DeptDAO{

	public void add() {
		System.out.println("执行DAO中的add方法...");
		
	}

	public void delete() {
		System.out.println("执行DAO中的delete方法...");
		
	}

	public void update() {
		System.out.println("执行DAO中的update方法...");
		
	}
	
}
