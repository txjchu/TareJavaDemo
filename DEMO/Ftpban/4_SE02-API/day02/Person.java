package day02;

import java.io.Serializable;
import java.util.List;

/**
 * �������ڲ��Զ�������д�����Ч��
 * 
 * ��һ�����ʵ���뱻ObjectOutputStreamת��Ϊ
 * һ���ֽں�д��(���л�)����ô�������ʵ�ֽӿ�:
 * java.io.Serializable��
 * �ýӿ�û���κγ��󷽷�������ֻ�Ǳ�ʾһ��������Ա�
 * ���л���
 * �ӿ�ͨ��������:
 * 1:Լ��������Ϊ��Ҳ������Ľӿ�Ӧ�ã����г��󷽷�
 * 2:��ǩ�ӿڣ���ʾ������Խ���ĳЩ�����ȵȣ�����Ϊ��
 *   Ҫ������������ĳЩ��Ϊ���ӿ�û�г��󷽷���
 *   
 *   
 * ���л�:��һ�����е����ݽṹ(intֵ,�ַ��������飬
 * ���ϣ������)ת��Ϊһ���ֽڵĹ���
 * 
 * �����л�:��һ���ֽڻ�ԭ�ض�Ӧ�����ݽṹ�Ĺ��̡�
 * 
 * ���л�����Ҫ��;:
 * 1:�洢
 * 2:����
 *   
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
	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	
	public String toString(){
		return name+","+age+","+
	           gender+","+otherInfo;
	}
	
} 





