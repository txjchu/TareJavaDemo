package oo.day05;
//接口的演示
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter6 o1 = new Inter6(); //编译错误，接口不能被实例化
		Inter6 o2 = new Foo(); //向上造型
		Inter5 o3 = new Foo(); //向上造型//接口可以作为一种类型声明变量，一个接口类型的变量可以引用实现该接口的对象
		o3.a();//通过该变量可以调用该接口中定义的方法（具体实现类提供了方法的实现）
		o2.a();
		o2.b();
		/*
		 * 接口的练习:
		 * 1.声明接口Inter1，包含常量PI和方法show()
		 * 2.声明接口Inter2，包含a()和b()
		 *   声明类Aoo，实现Inter2
		 * 3.声明接口Inter3，包含c()
		 *   声明类Boo，实现Inter2和Inter3
		 * 4.声明抽象类Coo，包含抽象方法d()
		 *   声明类Doo，继承Coo并实现Inter2和Inter3
		 * 5.声明接口Inter4，继承Inter3，包含e()
		 *   声明类Eoo，实现Inter4
		 * 6.main()方法中:
		 *    Inter4 o1 = new Eoo();-----???
		 *    Inter3 o2 = new Eoo();-----???
		 *    Inter2 o3 = new Eoo();-----???
		 */
	}
}

//接口的继承
interface Inter5{
	void a();
}
interface Inter6 extends Inter5{
	void b();
}
class Foo implements Inter6{
	public void b(){}
	public void a(){}
}



//继承类+实现接口
interface Inter3{
	void a();
	void b();
}
interface Inter4{
	void c();
}
abstract class Doo{
	abstract void d();
}
class Eoo extends Doo implements Inter3,Inter4{
	public void a(){}
	public void b(){}
	public void c(){}
	void d(){}
}


//接口的实现
interface Inter2{
	void a();
	void b();
}
class Coo implements Inter2{
	public void a(){}
	public void b(){}
}


//接口语法演示
interface Inter1{ 
	public static final double PI = 3.14159;
	public abstract void show();
	int NUM = 250; //默认public static final
	void say(); //默认public abstract
	
	//int a; //编译错误
	//void test(){} //编译错误
}


