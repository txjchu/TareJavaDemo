package oo.day02;
/*
 * 1) ͬһ���ļ��п����ж����
 * 2) ֻ����һ��public ���ε���
 * 3) public ���ε���������ļ�����ͬ
 */
//���ص���ʾ
public class OverloadDemo {
	public static void main(String[] args) {
		Aoo aoo = new Aoo();
		aoo.show();//�����޲η���
		aoo.show("lili");
		aoo.show(32, "lina");
		aoo.show("lina", 23);
	}
}
class Aoo{//�������ص���ʾ
	void show(){}
	void show(String name){	}
	void show(String name,int age){}
	void show(int age,String name){}
}
