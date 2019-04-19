package factory;

import test.Computer;
import test.MobilePhone;

/**
 * 用来练习Spring中bean的实例化
 * @author Administrator
 *
 */
public class Student {


	private int id;
	private String name;
	private int age;
	private String gender;
	private MobilePhone mobilePhone;
	private Computer computer;
	/*
	 * 无参构造
	 */
	public Student(){
		
	}
	/*
	 * 有参构造
	 */
	public Student(int id, String name, int age, String gender,
			MobilePhone mobilePhone, Computer computer) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobilePhone = mobilePhone;
		this.computer = computer;
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
	public MobilePhone getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(MobilePhone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", computer=" + computer
				+ ", mobilePhone=" + mobilePhone + "]";
	}
	
	
	
	
	
}
