package a02.day05;
//接口练习
public class InterfaceDemo {
	public static void main(String[] args) {
		inter4 o1 = new Eoo();
		o1.e();
		inter3 o2 = new Eoo();//接口可以作为一种类型声明变量，一个接口类型的变量可以引用实现该接口的对象
		o2.c();//通过该变量可以调用该接口中定义的方法（具体实现类提供了方法的实现）
//		inter2 o3 = new Eoo();//编译错误
	}
}
interface inter4 extends inter3{//接口4
	void e();
	void c();
}
class Eoo implements inter4{//Eoo类实现接口4
	public void c(){};
	public void e(){};
}
abstract class Coo{//抽象类Coo
	abstract void d();;
}
class Doo extends Coo implements inter2, inter3{//Doo类继承Coo，并实现接口2和接口3
	public void a(){};
	public void b(){};
	public void c(){};
	void d(){};
}
interface inter3{//接口3
	void c();
}
class Boo implements inter2, inter3{//Boo类实现了接口2和接口3
	public void a(){};//实现接口的类必须重写接口中定义的所有抽象方法
	public void b(){};
	public void c(){};
}
interface inter2{//接口2
	void a();
	void b();
}
class Aoo implements inter2{//实现接口2
	public void a(){};//实现接口的方法，访问控制符必须大于原来的
	public void b(){};
}

interface inter1{//接口1
	public static final double PI = 3.1415926;//常量
	int NUM =250;//系统默认public static final
	public void show();//系统默认该方法为abstract抽象的
}