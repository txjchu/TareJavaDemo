package oo.day04;
//static��ʾ
public class StaticDemo {
	public static void main(String[] args) {
		Joo o1 = new Joo();
		o1.show();
		Joo o2 = new Joo();
		o2.show();
		
		System.out.println(Joo.b); //2������д��
		System.out.println(o1.b);  //2��Ҳ���Զ�������
		
		Koo.test();
		
		Loo o3 = new Loo();
		Loo o4 = new Loo();
	}
}


class Loo{
	static{ //��̬�飬�౻����ʱִ�У�ִֻ��һ��
		System.out.println("��̬��");
	}
	Loo(){
		System.out.println("���췽��");
	}
}



class Koo{
	int a;
	static int b;
	void show(){
		a = 1;
		b = 2;
	}
	static void test(){
		//��̬������û����ʽthis��û��this��ζ��û�ж���
		//a��ʵ��������ʵ������ֻ�ܶ���������ʣ�
		//�����ھ�̬�����в���ֱ�ӷ���ʵ����Ա
		//a = 1; //�������
		b = 2;
	}
}





class Joo{ //��ʾ��̬����
	int a; //ʵ������
	static int b; //��̬����
	Joo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}













