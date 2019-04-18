package oo.day02;
/*
 * 1)同一个文件中可以包含多个类
 * 2)public修饰的类只能有一个
 * 3)public修饰的类必须与文件名相同
 */
//重载的演示
public class OverloadDemo {
	public static void main(String[] args) {
		Aoo o = new Aoo();
		//编译器在编译时自动根据方法的签名绑定调用不同的方法
		o.show(); //调无参的
		o.show("zhangsan");
		o.show("zhangsan", 25);
		o.show(25, "zhangsan");
	}
}

class Aoo{
	void show(){}
	void show(String name){}
	void show(String name,int age){}
	void show(int age,String name){}
	
	//int show(){return 1;} //编译错误，与返回值类型无关
	//void show(String str){} //编译错误，与参数名称无关
}










