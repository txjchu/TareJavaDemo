package oo.day04;
//��д����ʾ
public class OverrideDemo {
	public static void main(String[] args) {
	}
}

//���������С
//Tetromino t = new T(2,5); //��������(�Զ�����ת��)
class Aoo{
	void show(){}
	double say(){return 0.0;}
	Aoo test(){return null;}
	Boo get(){return null;}
}
class Boo extends Aoo{
	public void show(){} //voidʱ��������ͬ
	double say(){return 0.0;} //��������ʱ��������ͬ
	//Boo test(){return null;} //��ȷ��
	//Aoo get(){return null;} //�������
}









