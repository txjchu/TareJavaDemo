package oo.day04;
//重写与重载的演示
public class OverloadOverrideDemo {
	public static void main(String[] args) {
		//重载，看引用的类型
		//重写，看对象的类型
		Eoo eoo = new Eoo();
		Coo o = new Doo(); //向上造型
		eoo.test(o);
	}
}
class Eoo{
	void test(Coo o){
		System.out.println("父类型参数");
		o.show();
	}
	void test(Doo o){
		System.out.println("子类型参数");
		o.show();
	}
}
class Coo{
	void show(){
		System.out.println("父类show");
	}
}
class Doo extends Coo{
	void show(){
		System.out.println("子类show");
	}
}










