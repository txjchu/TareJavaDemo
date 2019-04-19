package day01;
/**
 * String 的不变特性
 * String 对象一旦被创建，表示字符串内容无法改变的，若想改变必须创建新对象。
 * @author Administrator
 *
 */
public class StringDemo001 {
	public static void main(String[] args) {
		//字面量  直接量
		String s1 = "123abc";
		String s2 = "123abc";
		String s3 = "123abc";
		String s4 = new String("123abc");
		/**  
		 *	修改s1后，s1会创建一个新的字符串对象，单独引用，不会影响s2原有的引用。
		 */
		System.out.println(s1 == s2);//true
		s1 = s1 +"!";
		System.out.println(s1);//123abc!
		System.out.println(s2);
		/**
		 * 使用字面量赋值会重用对象，使用new关键字则会创建新的对象。
		 */
		s1 = s2;
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//true
		System.out.println(s1 == s4);//false
		
		/**
		 * 编译器在编译源程序时，若发现一个计算表达式，且计算表达式两边内容都是字面量，则会直接将计算后的结果编译到class文件
		 * 中。所以JVM看到的样子是：
		 * String s5 = "123abc";
		 */
		String s5 = "123" + "abc";
		System.out.println(s2 == s5);//true
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1 == s6);//false
	}
}













