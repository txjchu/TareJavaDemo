package ioc3;

import java.io.Serializable;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("manager") 	//--使之变成一个bean，可以被容器管理
public class Manager implements Serializable {
	private Computer computer;
	@Value("苍老师")
	private String name;
	@Value("#{const.phone}")	//--通过Spring表达式访问id="const"的prop 的"phone"key。
	private String phone;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private int age;
		
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

	public Computer getComputer() {
		return computer;
	}
	
	@Resource(name="cp")	//--
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "computer(m):"+computer+"name："+name+"age："+age+"phone："+phone;
	}
	
	
}
