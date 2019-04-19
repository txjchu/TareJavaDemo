package day02;

import java.io.Serializable;
import java.util.List;

/**
 * 该类用于测试对象流读写对象的效果。
 * @author Administrator
 *
 * 当一个类的实例想被ObjectOutputStream 转换为一组字节后写出（序列化），
 * 那么该类必须实现接口：
 * java.io.Serializable/
 * 该接口没有任何抽象方法，作用只是标识一下子类可以被序列化。
 * 接口通常有两类：
 * 1.约束子类行为，也是最常见的接口应用，含有抽象方法；
 * 2.标签接口，提示该类可以进行某些操作等等，无需为此要求子类必须具有某些行为。此类接口没有抽象方法。
 * 
 * 
 * 【序列化】：将一个现有的数据结构(int值，字符串，数组，集合，对象等)转换为一组字节的过程。
 * 反序列化：将一组字节还原回对应的数据结构的过程。
 *
 * 序列化的主要用途：1.存储，	2.传输。
 *
 */
public class Person implements Serializable{
	/**
	 * 【版本号】
	 * 当一个类实现了序列化接口后，最好自行维护版本号。
	 * 版本号对序列化的结果产生影响。
	 * 当ObjectInputStream 在反序列化一个对象时，会检测该对象的版本号
	 * 与所属类现有的版本号是否一致，若一致则可以反序列化成功，否则反序列化失败。
	 * 版本号一致时：
	 * 若反序列化的对象与类的定义没有区别，则直接还原；
	 * 若现有类的定义与序列化的对象属性有差异了，则采取兼容模式，即：
	 * 现有类定义中的属性原来对象中没有的，则使用默认值。
	 * 现有类定义中没有的属性原来对象中有，则忽略。
	 * 剩下的全部还原。
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 当前类的实例若想进行序列化，除了自身需要实现序列化接口外，其中的所以引用类型的属性
	 * 也都需要实现序列化接口。使用java 提供的无需关系，因为他们都实现了序列化接口。
	 * 只有自定义的类型需要自行去实现。
	 */
	private String name ;
	private int age ;
	private String gender;
	/*
	 * transient关键字
	 * 当修饰一个属性后，该属性在序列化时将被忽略。
	 * 我们将无需保存的属性忽略掉可以达到对象序列化“瘦身”的效果。
	 */
	private  transient List<String> otherInfo; 	
	
	//无参构造
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
