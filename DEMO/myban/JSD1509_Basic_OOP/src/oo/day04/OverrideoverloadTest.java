package oo.day04;
//重写与重载的演示
public class OverrideoverloadTest {

	public static void main(String[] args) {
		Eoo eoo = new Eoo();
		Coo o = new Doo();
		eoo.test(o);
		
	}
}
class Eoo{
	void test(Coo o){
		System.out.println("父类的参数");
		o.show();
	}
	void test(){
		Doo o = new Doo();
		System.out.println("子类的参数");
		o.show();
	}
}
	
class Coo{
	void show(){
		System.out.println("父类的方法show();!");
	}
}	
class Doo extends Coo{
	void show(){
		System.out.println("子类的方法show();!");
	}
}
