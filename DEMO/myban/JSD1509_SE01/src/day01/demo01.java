package day01;
/** 字符串String */
public class demo01 {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";
		System.out.println(s1 == s2);
		String s4 = new String("123abc");
		System.out.println(s1 == s4);
		String s5 = "123" + "abc";//若发现一个计算式，计算符左右两边内容为字面量，则会直接将计算后的结果编译到class文件中.
		System.out.println(s1 == s5);
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1 == s6);
	}
}
