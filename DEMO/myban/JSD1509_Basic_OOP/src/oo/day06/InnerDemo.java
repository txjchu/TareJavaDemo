package oo.day06;

import oo.day06.Mama.Baby;

public class InnerDemo {
	public static void main(String[] args) {
		Mama m=new Mama();
		//Baby b=new Baby();//编译错误，内部类不具备可见性
	}
}

class Mama{  //外部类
	
	private String name;	//----private私有的
	Baby createBaby(){    //----
		return new Baby();	//----内部类对象通常只在外部类中创建
	}
	Baby b=new Baby();//--
	class Baby{   //内部类
		void showMamaName(){
		
		System.out.println(name);		//默认有个Mama.this.
		System.out.println(Mama.this.name);
		//System.out.println(this.name);		//---编译错误，this.表示当前类中的对象、特征
		}
	}
}