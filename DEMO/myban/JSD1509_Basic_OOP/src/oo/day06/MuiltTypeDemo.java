package oo.day06;
//��̬����ʾ
public class MuiltTypeDemo {
	public static void main(String[] args) {
		Aoo o1=new Boo();//��������
		//Boo o2=o1;//�������Aoo���ͣ�BooС
		Boo o2=(Boo)o1;//o1ָ��Ķ������Boo����
		Inter1 o3=(Inter1)o1;//�������ͣ�ǿ������ת����o1��ʵ�ֵĶ���ָ����Inter1�Ľӿ�
		//Coo o4=(Coo)o1;//ǿ������ת������������ת���쳣��ת�����ɹ�
		
		if(o1 instanceof Coo){    //false
			Coo o5=(Coo)o1;
		}
		
		Inter22 x = new y();
		Inter22 inter2 = x;
		y x2 = (y)x;
		x a =new y();
		y a1 = (y)a;
		x b = a1;
		x c = new z();
		
	}
}
interface Inter22{}
class x{}
class y extends x implements Inter22{}
class z extends x{}
interface Inter1{
	
}
class Aoo{
	
}
class Boo extends Aoo implements Inter1{
	
}
class Coo extends Aoo{
	
}
