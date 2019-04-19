package day02.homeWork;

import org.junit.Test;

/**
 * 作业第二题
 * value object
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private String gender;
	private double salary;
	
	//构造方法
	public Emp(String name, int age, String gender, double salary){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	/** 打印信息的方法 */
	public void paintInfo(){
		System.out.println("-----------");
		System.out.println("姓名："+ name);
		System.out.println("年龄："+ age);
		System.out.println("性别："+ gender);
		System.out.println("工资："+ salary);
	}
	
	@Override
	/** 重写equals()方法 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Emp){
			Emp emp = (Emp) obj;//强转类型
//			return this.name == emp.name;========错误！
			return this.name.equals(emp.name);//此处调用String的equals()方法
		}else{
			return false;
		}
	}

	@Override
	/** 重写toString()方法 */
	public String toString() {
		return name +","+ age +","+ gender +","+ salary;
	}
	
}

/** 测试类 */
class testEmp1{
	
	public static void main(String[] args) {
		Emp emp1 = new Emp("张三", 22, "男", 3333);
		
	}
	
	//测试
	@Test
	public void testPaintInfo(){
		Emp emp1 = new Emp("张三", 22, "男", 3333);
		emp1.paintInfo();
	}
}











