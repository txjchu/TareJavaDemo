package oo.day02;
//���췽������ʾ----�������--���԰ٶȰٿ�
public class RectDemo_baidu {
	public static void main(String[] args) {
		RectConstructor rect1 = new RectConstructor(10,20);//----���û���޲ι���Ļ������밴���вι�����ʽ����ʼ����������Ҫ���Ρ�
		RectConstructor rect2 = new RectConstructor(3,6);
		double ar;
		ar = rect1.area();
		System.out.println("��һ�����ε����"+ar);
		ar = rect2.area();
		System.out.println("�ڶ������ε����"+ar);
	}
}
class RectConstructor{
	double length;
	double width;
	double area(){//���
		return length*width;
	}
	RectConstructor(){};	//----�޲ι��췽����
	
	RectConstructor(double length,double width){	//----�вι��췽��
		this.length = length;
		this.width = width;
	}
}