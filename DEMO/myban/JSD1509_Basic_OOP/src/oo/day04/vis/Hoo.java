package oo.day04.vis;
import oo.day04.Foo;
//��ʾĬ�ϵ�
public class Hoo {
	void shou(){
		Foo o=new Foo();
		o.a=1;
		//o.b = 2; //����+����+ͬ����
		//o.c = 3; //����+ͬ����
		//o.d = 4; //����
	}
}
//��ʾprotected
class Ioo extends Foo{
	void show(){
		a=1;
		b=2;
		//c = 3; //����+ͬ����
		//d = 4; //����
		
	}
}