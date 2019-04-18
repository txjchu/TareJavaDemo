package oo.day04;
//static演示
public class StaticDemo {
	public static void main(String[] args) {
		Joo o1 = new Joo();
		o1.show();
		Joo o2 = new Joo();
		o2.show();
		
		System.out.println(Joo.b); //2，建议写法
		System.out.println(o1.b);  //2，也可以对象点访问
		
		Koo.test();
		
		Loo o3 = new Loo();
		Loo o4 = new Loo();
	}
}


class Loo{
	static{ //静态块，类被加载时执行，只执行一次
		System.out.println("静态块");
	}
	Loo(){
		System.out.println("构造方法");
	}
}



class Koo{
	int a;
	static int b;
	void show(){
		a = 1;
		b = 2;
	}
	static void test(){
		//静态方法中没有隐式this，没有this意味着没有对象，
		//a叫实例变量，实例变量只能对象点来访问，
		//所以在静态方法中不能直接访问实例成员
		//a = 1; //编译错误
		b = 2;
	}
}





class Joo{ //演示静态变量
	int a; //实例变量
	static int b; //静态变量
	Joo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}













