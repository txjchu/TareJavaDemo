package oo.day05;
//�ӿڵ���ʾ
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter6 o1 = new Inter6(); //������󣬽ӿڲ��ܱ�ʵ����
		Inter6 o2 = new Foo(); //��������
		Inter5 o3 = new Foo(); //��������//�ӿڿ�����Ϊһ����������������һ���ӿ����͵ı�����������ʵ�ָýӿڵĶ���
		o3.a();//ͨ���ñ������Ե��øýӿ��ж���ķ���������ʵ�����ṩ�˷�����ʵ�֣�
		o2.a();
		o2.b();
		/*
		 * �ӿڵ���ϰ:
		 * 1.�����ӿ�Inter1����������PI�ͷ���show()
		 * 2.�����ӿ�Inter2������a()��b()
		 *   ������Aoo��ʵ��Inter2
		 * 3.�����ӿ�Inter3������c()
		 *   ������Boo��ʵ��Inter2��Inter3
		 * 4.����������Coo���������󷽷�d()
		 *   ������Doo���̳�Coo��ʵ��Inter2��Inter3
		 * 5.�����ӿ�Inter4���̳�Inter3������e()
		 *   ������Eoo��ʵ��Inter4
		 * 6.main()������:
		 *    Inter4 o1 = new Eoo();-----???
		 *    Inter3 o2 = new Eoo();-----???
		 *    Inter2 o3 = new Eoo();-----???
		 */
	}
}

//�ӿڵļ̳�
interface Inter5{
	void a();
}
interface Inter6 extends Inter5{
	void b();
}
class Foo implements Inter6{
	public void b(){}
	public void a(){}
}



//�̳���+ʵ�ֽӿ�
interface Inter3{
	void a();
	void b();
}
interface Inter4{
	void c();
}
abstract class Doo{
	abstract void d();
}
class Eoo extends Doo implements Inter3,Inter4{
	public void a(){}
	public void b(){}
	public void c(){}
	void d(){}
}


//�ӿڵ�ʵ��
interface Inter2{
	void a();
	void b();
}
class Coo implements Inter2{
	public void a(){}
	public void b(){}
}


//�ӿ��﷨��ʾ
interface Inter1{ 
	public static final double PI = 3.14159;
	public abstract void show();
	int NUM = 250; //Ĭ��public static final
	void say(); //Ĭ��public abstract
	
	//int a; //�������
	//void test(){} //�������
}


