package oo.day06;
//�����ڲ������ʾ
public class NstInnerDemo {
	public static void main(String[] args) {
		//Inter2 o1=new Inter2();  //---������󣬽ӿڲ��ܱ�ʵ����
		
		//1.����Inter2��һ�����࣬û������(�����ڲ���)
		//2.Ϊ�����ഴ��һ��������Ϊo1
		//3.�������е�Ϊ���������
		
		Inter2 o1=new Inter2(){	
		};
		
		
		final int num=5;		//final���ɸı�ģ�������final
		//1.����Inter3��һ�����࣬û������
		//2.Ϊ�����ഴ����һ��������Ϊo3
		//3.��������Ϊ���������
		Inter3 o3=new Inter3(){			//----������дshow����
			public void show(){
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();		//----��ʾshowshow
	}
}
interface Inter3{
	void show();
}


interface Inter2{
	
}