package oo.day04;
//final演示
public class FinalDemo {
	public static void main(String[] args) {
	}
}



final class Poo{} //演示final修饰类
//class Qoo extends Poo{} //编译错误，final修饰的类不能被继承

class Roo{}
final class Soo extends Roo{} //正确，final的类可以继承别的类





class Noo{ //演示final修饰方法
	void show(){}
	final void say(){}
}
class Ooo extends Noo{
	void show(){}
	//void say(){} //编译错误，final修饰的方法不能被重写
}



class Moo{ //演示final修饰变量
	final int a = 1; //1.声明同时初始化
	final int b;
	Moo(){
		b = 2; //2.构造方法中初始化
	}
	void test(){
		//a = 2; //编译错误，final的变量不能被改变
		final int c; //final修饰局部变量，用之前初始化即可
	}
}













