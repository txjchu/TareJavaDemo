package oo.day02;
/*
 * 1)ͬһ���ļ��п��԰��������
 * 2)public���ε���ֻ����һ��
 * 3)public���ε���������ļ�����ͬ
 */
//���ص���ʾ
public class OverloadDemo {
	public static void main(String[] args) {
		Aoo o = new Aoo();
		//�������ڱ���ʱ�Զ����ݷ�����ǩ���󶨵��ò�ͬ�ķ���
		o.show(); //���޲ε�
		o.show("zhangsan");
		o.show("zhangsan", 25);
		o.show(25, "zhangsan");
	}
}

class Aoo{
	void show(){}
	void show(String name){}
	void show(String name,int age){}
	void show(int age,String name){}
	
	//int show(){return 1;} //��������뷵��ֵ�����޹�
	//void show(String str){} //�����������������޹�
}










