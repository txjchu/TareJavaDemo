package oo.day04.vis;
import oo.day04.Foo;

public class Hoo { //演示默认的
	void show(){
		Foo o = new Foo();
		o.a = 1;
		//o.b = 2; //本类+子类+同包类
		//o.c = 3; //本类+同包类
		//o.d = 4; //本类
	}
}

class Ioo extends Foo{ //演示protected
	void show(){
		a = 1;
		b = 2;
		//c = 3; //本类+同包类
		//d = 4; //本类
	}
}








