package org.tare.entity;
/**
 * ������ϰJAVA����ת��ΪJSON�����ʵ����
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
