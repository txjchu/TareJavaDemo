package a02.day05;
//�ӿ���ϰ
public class InterfaceDemo {
	public static void main(String[] args) {
		inter4 o1 = new Eoo();
		o1.e();
		inter3 o2 = new Eoo();//�ӿڿ�����Ϊһ����������������һ���ӿ����͵ı�����������ʵ�ָýӿڵĶ���
		o2.c();//ͨ���ñ������Ե��øýӿ��ж���ķ���������ʵ�����ṩ�˷�����ʵ�֣�
//		inter2 o3 = new Eoo();//�������
	}
}
interface inter4 extends inter3{//�ӿ�4
	void e();
	void c();
}
class Eoo implements inter4{//Eoo��ʵ�ֽӿ�4
	public void c(){};
	public void e(){};
}
abstract class Coo{//������Coo
	abstract void d();;
}
class Doo extends Coo implements inter2, inter3{//Doo��̳�Coo����ʵ�ֽӿ�2�ͽӿ�3
	public void a(){};
	public void b(){};
	public void c(){};
	void d(){};
}
interface inter3{//�ӿ�3
	void c();
}
class Boo implements inter2, inter3{//Boo��ʵ���˽ӿ�2�ͽӿ�3
	public void a(){};//ʵ�ֽӿڵ��������д�ӿ��ж�������г��󷽷�
	public void b(){};
	public void c(){};
}
interface inter2{//�ӿ�2
	void a();
	void b();
}
class Aoo implements inter2{//ʵ�ֽӿ�2
	public void a(){};//ʵ�ֽӿڵķ��������ʿ��Ʒ��������ԭ����
	public void b(){};
}

interface inter1{//�ӿ�1
	public static final double PI = 3.1415926;//����
	int NUM =250;//ϵͳĬ��public static final
	public void show();//ϵͳĬ�ϸ÷���Ϊabstract�����
}