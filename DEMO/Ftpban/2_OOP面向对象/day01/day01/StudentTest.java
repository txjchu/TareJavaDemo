package oo.day01;
//ѧ���������
public class StudentTest {
	public static void main(String[] args) {
		Student zs = new Student(); //����һ��ѧ������
		zs.name = "zhangsan";
		zs.age = 25;
		zs.address = "�ӱ��ȷ�";
		zs.study();
		zs.sayHi();
		
		Student ls = new Student();
		ls.name = "lisi";
		ls.age = 18;
		ls.address = "��������ľ˹";
		ls.study();
		ls.sayHi();
		
		Student ww = new Student();
		ww.study();
		ww.sayHi(); //Ĭ�ϳ�ʼ��
		
	}
}










