package oo.day01;
//�������ͻ��Ⱥ���null��ʾ
public class RefAndNullDemo {
	public static void main(String[] args) {
		/*
		Cell c1 = new Cell();
		Cell c2 = c1; //ָ��ͬһ������
		c1.row = 2;
		c2.row = 5;
		System.out.println(c1.row); //5
		int a = 5;
		int b = a; //��ֵ
		a = 8;
		System.out.println(b); //5
		*/
		Cell c = new Cell();
		System.out.println(c.row); //0
		c = null; //�գ�����ָ���κζ���
		System.out.println(c.row); //��ָ���쳣
	}
}













