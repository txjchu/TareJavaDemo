package oo.day03;
//����������ʾ
public class UpDemo {
	public static void main(String[] args) {
		Eoo o1 = new Eoo();
		o1.a = 1;
		o1.show();
		//o1.b = 2; //������󣬸����ܷ����ӵ�
		
		Foo o2 = new Foo();
		o2.b = 1;
		o2.say();
		o2.a = 2; //�ӿ��Է��ʸ���
		o2.show();
		
		Eoo o3 = new Foo(); //��������
		o3.a = 1;
		o3.show();
		//o3.b = 2; //��������ܵ����ʲô�����õ�����
	}
}

class Eoo{
	int a;
	void show(){}
}
class Foo extends Eoo{
	int b;
	void say(){}
}
