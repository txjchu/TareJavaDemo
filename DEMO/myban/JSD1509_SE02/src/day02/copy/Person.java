package day02.copy;

import java.io.Serializable;
import java.util.List;

/**
 *  该类用于测试对象流的读写对象的效果。
 * 
 *  当一个类的实例想被ObjectOutputStream转换为一组字节后写出（序列化），那么该类必须实现接口：
 *  java.io.Serializable。
 *  该接口没有任何抽象方法，作用只是标识一下子类可以被序列化。
 *  
 *  接口通常有两类：
 *  1.约束子类行为，也是常见的接口应用，含有抽象方法。
 *  2.标签接口，提示该类可以进行某些操作等等，无需为此要求子类必须具有某些行为。接口内不包含抽象方法。
 *  
 *  序列化：将一个现有的数据结构（int值，字符串，数组，集合，对象等）转化为一组字节的过程。
 *  反序列化：将一组字节还原回对应的数据结构的过程。
 *  
 *  序列画的主要用途：
 *  1.存储	2.传输。
 * @author Administrator
 *
 */
public class Person implements Serializable{
	private String name;
	private int age;
	private String gender;
	private List<String> otherInfo;
	public Person(){
		
	}
	public Person(String name, int age, String gander, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gander;
		this.otherInfo = otherInfo;
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
	public List<String> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return name +","+ age +","+ gender +","+ otherInfo ;
	}

}





















