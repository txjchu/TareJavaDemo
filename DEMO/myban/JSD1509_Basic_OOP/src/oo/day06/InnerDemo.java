package oo.day06;

import oo.day06.Mama.Baby;

public class InnerDemo {
	public static void main(String[] args) {
		Mama m=new Mama();
		//Baby b=new Baby();//��������ڲ��಻�߱��ɼ���
	}
}

class Mama{  //�ⲿ��
	
	private String name;	//----private˽�е�
	Baby createBaby(){    //----
		return new Baby();	//----�ڲ������ͨ��ֻ���ⲿ���д���
	}
	Baby b=new Baby();//--
	class Baby{   //�ڲ���
		void showMamaName(){
		
		System.out.println(name);		//Ĭ���и�Mama.this.
		System.out.println(Mama.this.name);
		//System.out.println(this.name);		//---�������this.��ʾ��ǰ���еĶ�������
		}
	}
}