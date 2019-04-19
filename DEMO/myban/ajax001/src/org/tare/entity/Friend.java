package org.tare.entity;
/**
 * 用来练习JAVA对象转换为JSON对象的实体类
 * @author Administrator
 *
 */
public class Friend {
	private String name;
	private Integer age;
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
	@Override
	public String toString() {
		return "Friend [name=" + name + ", age=" + age + "]";
	}
	
	
}
