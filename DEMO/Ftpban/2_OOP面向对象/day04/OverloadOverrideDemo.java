package oo.day04;
//��д�����ص���ʾ
public class OverloadOverrideDemo {
	public static void main(String[] args) {
		//���أ������õ�����
		//��д�������������
		Eoo eoo = new Eoo();
		Coo o = new Doo(); //��������
		eoo.test(o);
	}
}
class Eoo{
	void test(Coo o){
		System.out.println("�����Ͳ���");
		o.show();
	}
	void test(Doo o){
		System.out.println("�����Ͳ���");
		o.show();
	}
}
class Coo{
	void show(){
		System.out.println("����show");
	}
}
class Doo extends Coo{
	void show(){
		System.out.println("����show");
	}
}










