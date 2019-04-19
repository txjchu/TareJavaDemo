package oo.day02;
/*
 * 1) 同一个文件中可以有多个类
 * 2) 只能有一个public 修饰的类
 * 3) public 修饰的类必须与文件名相同
 */
//重载的演示
public class OverloadDemo {
	public static void main(String[] args) {
		Aoo aoo = new Aoo();
		aoo.show();//调用无参方法
		aoo.show("lili");
		aoo.show(32, "lina");
		aoo.show("lina", 23);
	}
}
class Aoo{//方法重载的演示
	void show(){}
	void show(String name){	}
	void show(String name,int age){}
	void show(int age,String name){}
}
