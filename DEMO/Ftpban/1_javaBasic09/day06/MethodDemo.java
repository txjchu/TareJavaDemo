package day06;
//��������ʾ
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		
		//sayHi(); //��������в�����봫��
		//sayHi(250); //������󣬲������ͱ���ƥ��
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		//sayHi("wangwu"); //String name="wangwu"
		
		//int num = getNum(); //getNum()��ֵ����return���250
		//System.out.println(num);
		
		//double a = plus(5.5,6.6); //double num1=5.5,double num2=6.6
		//System.out.println(a);
		
		//������һ�����ʣ�����������������Ǹ���
		//double a = 5.5;
		//double b = 6.6;
		//double c = plus(a,b); //double num1=5.5,double num2=6.6
		//System.out.println(c);
		
		//������Ƕ�׵���(�����е�����)
		a();//222,444,333,111,
		
		System.out.println("over");
	}
	
	public static void a(){
		b();
		System.out.println(111);
	}
	public static void b(){
		System.out.println(222);
		c();
		System.out.println(333);
	}
	public static void c(){
		System.out.println(444);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//�в��з���ֵ
	public static double plus(double num1,double num2){
		//double num=num1+num2;
		//return num;
		return num1+num2;
	}
	
	//�޲��з���ֵ
	public static int getNum(){
		//return; //������󣬱��뷵��һ��ֵ
		//return 25.6; //������󣬷���ֵ���ͱ���ƥ��
		return 250; //1.����������ִ��  2.���ؽ�������÷�
	}
	
	//�в��޷���ֵ
	public static void sayHi(String name){
		System.out.println("��Һã��ҽ�"+name);
		return; //1.����������ִ��
	}
	
	//�޲��޷���ֵ
	public static void say(){
		System.out.println("��Һã��ҽ�WKJ");
	}
	
}












