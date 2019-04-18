package oo.day02;
//T型和J型测试类
public class TJTest {
	public static void main(String[] args) {
		T t = new T(2,5);
		System.out.println("原始位置:");
		t.print();
		
		System.out.println("下落一格:");
		t.drop();
		t.print();
		
		System.out.println("左移一格:");
		t.moveLeft();
		t.print();
	}
}









