package oo.day01;
//引用类型画等号与null演示
public class RefAndNullDemo {
	public static void main(String[] args) {
		/*
		Cell c1 = new Cell();
		Cell c2 = c1; //指向同一个对象
		c1.row = 2;
		c2.row = 5;
		System.out.println(c1.row); //5
		int a = 5;
		int b = a; //赋值
		a = 8;
		System.out.println(b); //5
		*/
		Cell c = new Cell();
		System.out.println(c.row); //0
		c = null; //空，不再指向任何对象
		System.out.println(c.row); //空指针异常
	}
}













