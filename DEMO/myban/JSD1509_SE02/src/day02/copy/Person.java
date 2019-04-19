package day02.copy;

import java.io.Serializable;
import java.util.List;

/**
 *  �������ڲ��Զ������Ķ�д�����Ч����
 * 
 *  ��һ�����ʵ���뱻ObjectOutputStreamת��Ϊһ���ֽں�д�������л�������ô�������ʵ�ֽӿڣ�
 *  java.io.Serializable��
 *  �ýӿ�û���κγ��󷽷�������ֻ�Ǳ�ʶһ��������Ա����л���
 *  
 *  �ӿ�ͨ�������ࣺ
 *  1.Լ��������Ϊ��Ҳ�ǳ����Ľӿ�Ӧ�ã����г��󷽷���
 *  2.��ǩ�ӿڣ���ʾ������Խ���ĳЩ�����ȵȣ�����Ϊ��Ҫ������������ĳЩ��Ϊ���ӿ��ڲ��������󷽷���
 *  
 *  ���л�����һ�����е����ݽṹ��intֵ���ַ��������飬���ϣ�����ȣ�ת��Ϊһ���ֽڵĹ��̡�
 *  �����л�����һ���ֽڻ�ԭ�ض�Ӧ�����ݽṹ�Ĺ��̡�
 *  
 *  ���л�����Ҫ��;��
 *  1.�洢	2.���䡣
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





















