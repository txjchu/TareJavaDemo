package oo.day01;
//学生类
public class Student {
	String name; //姓名
	int age; //年龄
	String address; //地址
	
	void study(){ //学习
		System.out.println(name+"在学习...");
	}
	void sayHi(){ //问好
		System.out.println("大家好，我叫"+name+"，今年"+age+"岁了，家住"+address);
	}
}






