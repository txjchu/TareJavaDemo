package demo;

public class A {
	int a = 1;
	double d = 2.0;
	void show(){
		System.out.println("Class A:a="+a+"\td="+d);
	}
	public static void main(String[] args) {
//		A a = new A();
//		a.show();
		A b = new B();
		b.show();
	}
}
class B extends A{
	Float a = 3.0f;
	String d = "java program.";
	void show(){
		super.show();
		System.out.println("Class B:a="+a+"\td="+d);
	}	
}
