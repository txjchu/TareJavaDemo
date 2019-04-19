package com.jeeplus.modules.usertest.entity;

import org.h2.engine.Database;

import com.jeeplus.common.persistence.DataEntity;

/**
 * 测试员实体类
 * @author Administrator
 *
 */

public class UserTest extends DataEntity<UserTest>{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String age;
	private String job;
	private String salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	
}
