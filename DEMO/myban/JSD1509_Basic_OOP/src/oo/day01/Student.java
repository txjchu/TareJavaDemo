package oo.day01;
//ѧ����
public class Student {
/*
	String name;
	int age;
	String address;
	void Study(){
		System.out.println(name+"��ѧϰ....");
	}
	void sayHi(){
		System.out.println("��Һã��ҽ�"+name+"����"+age+"���ˣ�������"+address);
	}
*/
	String name;
	int age;
	String address;
	void Study(){
		System.out.println(name +"��ѧϰ...");
	}
	void sayHi(){
		System.out.println("��Һã��ҽ�"+ name +"����"+ age +"���ˣ�������"+ address);
	}
	public static void main(String[] args) {
		Student lilei = new Student();
		lilei.name = "lilei";
		lilei.age = 12;
		lilei.address = "�����";
		lilei.sayHi();
		lilei.Study();
			
	}
}

