package oo.day04.vis;
import oo.day04.Foo;

public class Hoo { //��ʾĬ�ϵ�
	void show(){
		Foo o = new Foo();
		o.a = 1;
		//o.b = 2; //����+����+ͬ����
		//o.c = 3; //����+ͬ����
		//o.d = 4; //����
	}
}

class Ioo extends Foo{ //��ʾprotected
	void show(){
		a = 1;
		b = 2;
		//c = 3; //����+ͬ����
		//d = 4; //����
	}
}








