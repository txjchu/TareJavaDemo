package oo.day06;
//匿名内部类演示
public class NstInnerDemo {
	public static void main(String[] args) {
		//Inter2 o1 = new Inter2(); //编译错误
		
		//1.创建Inter2的一个子类，没有名字(匿名内部类)
		//2.为该子类创建一个对象，名为o1
		//3.大括号中的为子类的类体
		Inter2 o1 = new Inter2(){
			
		};
	
		//1.创建Inter2的一个子类，没有名字(匿名内部类)
		//2.为该子类创建一个对象，名为o2
		//3.大括号中的为子类的类体
		Inter2 o2 = new Inter2(){
			
		};
		
		final int num = 5; //必须是final的
		//1.创建Inter3的一个子类，没有名字
		//2.为该子类创建了一个对象，名为o3
		//3.大括号中为子类的类体
		Inter3 o3 = new Inter3(){
			public void show(){
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();
		
	}
}

interface Inter3{
	void show();
}

interface Inter2{
}













