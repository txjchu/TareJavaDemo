package day06;
//��������ʾ	
public class MethodDemo {
	public static void main(String[] args) {
		say();
	
		System.out.println("over");
	}
	
	//������Ƕ�ף������е��÷���
	
	//�в����з���ֵ
	public static double plus(double num1,double num2){
		double num=num1+num2;
		return num;
	}
	
	//�����з���ֵ�ģ����õ�ʱ���������һ�����������ղ���
	//�޲����з���ֵ
	public static double getNum(){
		//return;//������󣬱��뷴��һ��ֵ
		//return "abc";
		return 25.6;//������󣬷���ֵ���ͱ������  //1.����������ִ�� 2.���ؽ�������÷�
		//return 25;
	}
	
	//�в����޷���ֵ
	public static void sayHi(String name){
		
	}
	
	//�޲����޷���ֵ
	public static void say(){
		System.out.println("��Һã��ҽ�WKJ");
	}
}
