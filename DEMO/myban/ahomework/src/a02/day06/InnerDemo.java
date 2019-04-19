package a02.day06;
//内部类练习
public class InnerDemo {
	public static void main(String[] args) {
		Outer out = new Outer("33");
		out.printName();
	}
}
class Outer{//外部类
	private String name ;
	private Inner inn;
	public Outer(String str){
		this.name = str;
		this.inn = this.buildInner();
	}
	public void printName(){
		System.out.println(this.name);
		inn.showOuterName();
	}
	Inner buildInner(){
		return new Inner();//内部类对象通常只能在外部类中创建
	}
	class Inner{//内部类
		void showOuterName(){
			System.out.println(name);//默认添加Outer.this
			System.out.println(Outer.this.name);
		}
	}
}