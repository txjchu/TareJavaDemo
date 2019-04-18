package oo.day06;
//内部类演示
public class InnerDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby(); //编译错误，内部类对外不具备可见性
	}
}

class Mama{
	private String name;
	Baby createBaby(){
		return new Baby(); //内部类对象通常只在外部类中创建
	}
	class Baby{
		void showMamaName(){
			System.out.println(name); //前面默认有个Mama.this
			System.out.println(Mama.this.name);
			//System.out.println(this.name); //编译错误
		}
	}
}











