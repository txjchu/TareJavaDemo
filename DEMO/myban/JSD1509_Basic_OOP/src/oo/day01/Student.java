package oo.day01;
//学生类
public class Student {
/*
	String name;
	int age;
	String address;
	void Study(){
		System.out.println(name+"在学习....");
	}
	void sayHi(){
		System.out.println("大家好，我叫"+name+"今年"+age+"岁了，我来自"+address);
	}
*/
	String name;
	int age;
	String address;
	void Study(){
		System.out.println(name +"在学习...");
	}
	void sayHi(){
		System.out.println("大家好，我叫"+ name +"今年"+ age +"岁了，我来自"+ address);
	}
	public static void main(String[] args) {
		Student lilei = new Student();
		lilei.name = "lilei";
		lilei.age = 12;
		lilei.address = "东大街";
		lilei.sayHi();
		lilei.Study();
			
	}
}

