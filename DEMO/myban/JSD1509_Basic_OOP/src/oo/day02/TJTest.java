package oo.day02;
//T�ͺ�J�͵Ĳ�����
public class TJTest {

	public static void main(String[] args) {
		T t = new T(2,5);
		System.out.println("ԭʼλ�ã�");
		t.print();
		
		System.out.println("�½�һ��");
		t.drop();
		t.print();
		
		System.out.println("����һ��");
		t.moveLeft();
		t.print();
		
	}

}
