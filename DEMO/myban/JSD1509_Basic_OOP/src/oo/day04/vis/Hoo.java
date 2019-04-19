package oo.day04.vis;
import oo.day04.Foo;
//演示默认的
public class Hoo {
	void shou(){
		Foo o=new Foo();
		o.a=1;
		//o.b = 2; //本类+子类+同包类
		//o.c = 3; //本类+同包类
		//o.d = 4; //本类
	}
}
//演示protected
class Ioo extends Foo{
	void show(){
		a=1;
		b=2;
		//c = 3; //本类+同包类
		//d = 4; //本类
		
	}
}