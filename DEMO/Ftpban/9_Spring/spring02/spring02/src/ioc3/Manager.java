package ioc3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("manager")
public class Manager {
	@Value("≤‘¿œ ¶")
	private String name;
	private int age;
	@Value("#{const.phone}")
	private String phone;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	
	@Value("22")
	public void setAge(int age) {
		this.age = age;
	}

	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	
	@Resource(name="cp")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "computer:" + computer 
		+ "name:" + name + "age:" 
		+ age + "phone:" + phone;
	}
	
}
