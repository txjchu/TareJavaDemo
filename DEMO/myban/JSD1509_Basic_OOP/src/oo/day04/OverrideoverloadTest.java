package oo.day04;
//��д�����ص���ʾ
public class OverrideoverloadTest {

	public static void main(String[] args) {
		Eoo eoo = new Eoo();
		Coo o = new Doo();
		eoo.test(o);
		
	}
}
class Eoo{
	void test(Coo o){
		System.out.println("����Ĳ���");
		o.show();
	}
	void test(){
		Doo o = new Doo();
		System.out.println("����Ĳ���");
		o.show();
	}
}
	
class Coo{
	void show(){
		System.out.println("����ķ���show();!");
	}
}	
class Doo extends Coo{
	void show(){
		System.out.println("����ķ���show();!");
	}
}
