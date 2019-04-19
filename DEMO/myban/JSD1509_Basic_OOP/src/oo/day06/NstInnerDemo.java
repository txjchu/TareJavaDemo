package oo.day06;
//匿名内部类的演示
public class NstInnerDemo {
	public static void main(String[] args) {
		//Inter2 o1=new Inter2();  //---编译错误，接口不能被实例化
		
		//1.创建Inter2的一个子类，没有名字(匿名内部类)
		//2.为该子类创建一个对象，名为o1
		//3.大括号中的为子类的类体
		
		Inter2 o1=new Inter2(){	
		};
		
		
		final int num=5;		//final不可改变的，必须是final
		//1.创建Inter3的一个子类，没有名字
		//2.为该子类创建了一个对象，名为o3
		//3.大括号中为子类的类体
		Inter3 o3=new Inter3(){			//----必须重写show方法
			public void show(){
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();		//----显示showshow
	}
}
interface Inter3{
	void show();
}


interface Inter2{
	
}