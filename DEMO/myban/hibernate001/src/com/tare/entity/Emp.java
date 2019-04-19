package com.tare.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 数据表emp_h对应的实体类
 * @author Administrator
 *
 */
public class Emp {
	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private Boolean marry;
	private Date birthday;
	private Timestamp last_login_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Boolean isMarry() {
		return marry;
	}
	public void setMarry(Boolean marry) {
		this.marry = marry;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Timestamp getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Timestamp lastLoginTime) {
		last_login_time = lastLoginTime;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", marry="
				+ marry + ", birthday=" + birthday + ", salary=" + salary
				+ ", last_login_time=" + last_login_time + "]";
	}
	
	
}
