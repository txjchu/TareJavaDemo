package day02;

public class IntegerDemo004 {
	public static void main(String[] args) {
		/*
		 * JAVA1.5以后推出一个新的特性，自动拆装箱。自动拆装箱不是JVM认可的，而是编译器认可的。
		 * 当编译器遇到下面的代码时，认为我们需要将引用类型转换为基本类型时，自动在编译后的class文件中补充了代码，
		 * 所以下面的代码在class文件中的样子是：
		 * int i = new Integer(1).intValue();
		 * 补充代码后会将引用类型转换为基本类型，这个就称为自动拆箱。
		 */
		int i  = new Integer(1);
		/*
		 * 当编译器编译下面的代码时，发现需要将基本类型转换为引用类型时，会自动补充全代码：
		 * Integer a = Integer.valueOf(1);
		 * 这个过程就称为自动装箱。
		 */
		Integer a = 1;
		dosome(1);//现在就可以应用到面向对象的开发过程中了。
		System.out.println(a);
		
	}
	public static void dosome(Object o){
		
	}
}












