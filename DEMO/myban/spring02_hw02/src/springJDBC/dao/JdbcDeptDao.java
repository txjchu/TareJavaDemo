package springJDBC.dao;

import org.springframework.stereotype.Repository;



@Repository
public class JdbcDeptDao implements DeptDao{

	public void add() {
		System.out.println("利用JDBC保存Dept信息，调用DeptDao");
		
	}

	public void delete() {
		System.out.println("利用JDBC删除Dept信息，调用DeptDao");
	}

	public void update() {
		System.out.println("利用JDBC更新修改Dept信息，调用DeptDao");
	}
	

}
