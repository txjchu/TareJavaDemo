package oo.day05;
//static final常量演示
public class StaticFinalDemo {
	public static void main(String[] args) {
		//System.out.println(Aoo.NUM); //输出NUM的值
		//Aoo.NUM = 360; //编译错误，常量不能被改变
		
		//1.加载Boo.class到方法区
		//2.num存在方法区中并赋值为250
		//3.到方法区中获取num的值并输出
		System.out.println(Boo.num);
		
		//编译器在编译时被直接替换为3.14159，效率高
		//等价于System.out.println(3.14159);
		System.out.println(Boo.PI);
		
	}
}

class Boo{
	public static final double PI = 3.14159; //常量
	public static int num = 250; //静态变量
}

class Aoo{
	public static final int NUM = 250;
	//public static final int NUM2; //编译错误，必须声明同时初始化
}











