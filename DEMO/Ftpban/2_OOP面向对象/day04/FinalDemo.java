package oo.day04;
//final��ʾ
public class FinalDemo {
	public static void main(String[] args) {
	}
}



final class Poo{} //��ʾfinal������
//class Qoo extends Poo{} //�������final���ε��಻�ܱ��̳�

class Roo{}
final class Soo extends Roo{} //��ȷ��final������Լ̳б����





class Noo{ //��ʾfinal���η���
	void show(){}
	final void say(){}
}
class Ooo extends Noo{
	void show(){}
	//void say(){} //�������final���εķ������ܱ���д
}



class Moo{ //��ʾfinal���α���
	final int a = 1; //1.����ͬʱ��ʼ��
	final int b;
	Moo(){
		b = 2; //2.���췽���г�ʼ��
	}
	void test(){
		//a = 2; //�������final�ı������ܱ��ı�
		final int c; //final���ξֲ���������֮ǰ��ʼ������
	}
}













