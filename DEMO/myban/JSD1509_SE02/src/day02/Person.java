package day02;

import java.io.Serializable;
import java.util.List;

/**
 * �������ڲ��Զ�������д�����Ч����
 * @author Administrator
 *
 * ��һ�����ʵ���뱻ObjectOutputStream ת��Ϊһ���ֽں�д�������л�����
 * ��ô�������ʵ�ֽӿڣ�
 * java.io.Serializable/
 * �ýӿ�û���κγ��󷽷�������ֻ�Ǳ�ʶһ��������Ա����л���
 * �ӿ�ͨ�������ࣺ
 * 1.Լ��������Ϊ��Ҳ������Ľӿ�Ӧ�ã����г��󷽷���
 * 2.��ǩ�ӿڣ���ʾ������Խ���ĳЩ�����ȵȣ�����Ϊ��Ҫ������������ĳЩ��Ϊ������ӿ�û�г��󷽷���
 * 
 * 
 * �����л�������һ�����е����ݽṹ(intֵ���ַ��������飬���ϣ������)ת��Ϊһ���ֽڵĹ��̡�
 * �����л�����һ���ֽڻ�ԭ�ض�Ӧ�����ݽṹ�Ĺ��̡�
 *
 * ���л�����Ҫ��;��1.�洢��	2.���䡣
 *
 */
public class Person implements Serializable{
	/**
	 * ���汾�š�
	 * ��һ����ʵ�������л��ӿں��������ά���汾�š�
	 * �汾�Ŷ����л��Ľ������Ӱ�졣
	 * ��ObjectInputStream �ڷ����л�һ������ʱ������ö���İ汾��
	 * �����������еİ汾���Ƿ�һ�£���һ������Է����л��ɹ����������л�ʧ�ܡ�
	 * �汾��һ��ʱ��
	 * �������л��Ķ�������Ķ���û��������ֱ�ӻ�ԭ��
	 * ��������Ķ��������л��Ķ��������в����ˣ����ȡ����ģʽ������
	 * �����ඨ���е�����ԭ��������û�еģ���ʹ��Ĭ��ֵ��
	 * �����ඨ����û�е�����ԭ���������У�����ԡ�
	 * ʣ�µ�ȫ����ԭ��
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ��ǰ���ʵ������������л�������������Ҫʵ�����л��ӿ��⣬���е������������͵�����
	 * Ҳ����Ҫʵ�����л��ӿڡ�ʹ��java �ṩ�������ϵ����Ϊ���Ƕ�ʵ�������л��ӿڡ�
	 * ֻ���Զ����������Ҫ����ȥʵ�֡�
	 */
	private String name ;
	private int age ;
	private String gender;
	/*
	 * transient�ؼ���
	 * ������һ�����Ժ󣬸����������л�ʱ�������ԡ�
	 * ���ǽ����豣������Ժ��Ե����Դﵽ�������л���������Ч����
	 */
	private  transient List<String> otherInfo; 	
	
	//�޲ι���
	public Person(){}
	
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
		return name+","+age+","+gender+","+otherInfo;
	}
	
	
}
