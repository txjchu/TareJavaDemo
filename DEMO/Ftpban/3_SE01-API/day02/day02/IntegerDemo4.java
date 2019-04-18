package day02;

public class IntegerDemo4 {
	public static void main(String[] args) {
		/*
		 * JAVA1.5以后推出了一个新的特性，自动拆装
		 * 箱。自动查装箱不是JVM认可的，而是编译器
		 * 认可的。
		 * 当编译器遇到下面的代码时，认为我们需要将
		 * 引用类型转换为基本类型时，自动在编译后的
		 * class文件中补充了代码，所以下面的代码
		 * 在class中的样子是:
		 * int i = new Integer(1).intValue()
		 * 补充代码后会将饮用类型转换为基本类型，这个
		 * 就成为自动拆箱。
		 */
		int i = new Integer(1);
		/*
		 * 当编译器编译下面的代码时，发现需要将基本
		 * 类型转换为引用类型时，会自动补全代码:
		 * Integer a = Integer.valueOf(1);
		 * 这个过程称为自动装箱。
		 */
		Integer a = 1;
		
		dosome(1);
	}
	
	public static void dosome(Object o){
		
	}
}
