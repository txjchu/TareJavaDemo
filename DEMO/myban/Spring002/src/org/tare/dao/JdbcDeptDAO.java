package org.tare.dao;

import org.springframework.stereotype.Repository;

@Repository		//�־ò����ע��
public class JdbcDeptDAO implements DeptDAO{

	public void add() {
		System.out.println("ִ��DAO�е�add����...");
		
	}

	public void delete() {
		System.out.println("ִ��DAO�е�delete����...");
		
	}

	public void update() {
		System.out.println("ִ��DAO�е�update����...");
		
	}
	
}
