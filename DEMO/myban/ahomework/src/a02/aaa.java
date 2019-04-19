package a02;

public class aaa {
	public static void main(String[] args) {
		Outer out = new Outer("111");
		out.print();
	}
}
class Outer{//外部类
	private String name;
	private Inner inn;
	public Outer(String name){
		this.name = name;
		this.inn = this.buildInner(); 
	}
	public void print(){
		System.out.println("外部类中输出的"+ name);
		inn.showOuterName();
	}
	Inner buildInner(){
		return new Inner();
	}
	class Inner{//内部类
		void showOuterName(){
			System.out.println("内部类中输出的"+ Outer.this.name);
		}
	}
}