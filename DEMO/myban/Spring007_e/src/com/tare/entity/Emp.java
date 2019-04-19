package com.tare.entity;

import java.io.Serializable;

/**
 * t_emp表的实体类
 * @author Administrator
 *
 */
public class Emp implements Serializable{
	private Integer id;
	private String name;
	private Double salary;
	private Integer age;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	
}
