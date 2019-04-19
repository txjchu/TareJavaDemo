package emp.entity;

import java.io.Serializable;

public class Emp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double salary;
	private int age;

	
	
	
	
	public Emp() {
		super();
	}
	public Emp(int id ,String name, double salary, int age) {
		super();
		this.id=id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return id+","+ name+","+salary+","+age;
	}
	
	
	
}
