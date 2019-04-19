package org.tare.ioc;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 练习@Value注解注入Spring表达式的值
 * @author Administrator
 *
 */
@Component
public class DemoBean implements Serializable {
	@Value("#{info.name}")
	private String name;
	@Value("#{info.phone}")
	private String phone;
	
	@Value("22")
	private int age;
	@Value("老师")
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
