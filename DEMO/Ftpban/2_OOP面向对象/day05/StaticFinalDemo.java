package oo.day05;
//static final������ʾ
public class StaticFinalDemo {
	public static void main(String[] args) {
		//System.out.println(Aoo.NUM); //���NUM��ֵ
		//Aoo.NUM = 360; //������󣬳������ܱ��ı�
		
		//1.����Boo.class��������
		//2.num���ڷ������в���ֵΪ250
		//3.���������л�ȡnum��ֵ�����
		System.out.println(Boo.num);
		
		//�������ڱ���ʱ��ֱ���滻Ϊ3.14159��Ч�ʸ�
		//�ȼ���System.out.println(3.14159);
		System.out.println(Boo.PI);
		
	}
}

class Boo{
	public static final double PI = 3.14159; //����
	public static int num = 250; //��̬����
}

class Aoo{
	public static final int NUM = 250;
	//public static final int NUM2; //������󣬱�������ͬʱ��ʼ��
}











