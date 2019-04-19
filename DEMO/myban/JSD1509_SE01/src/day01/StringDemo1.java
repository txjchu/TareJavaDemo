package day01;
/**
 * String的不变特性
 * String 对象一旦创建，表示的字符串内容是无法改变的
 * 若想改变必须创建新对象
 * 原因：
 * 由于在开发中发现字符串重用比修改几率大很多，所以Java将使用字面量创建的对象，若内容一样就重用
 * 之前的对象，避免创建重复内容来减少内存开销。
 * 这导致字符串对象往往是“公用的”。
 * @author Administrator
 *
 */

public class StringDemo1 {
	public static void main(String[] args){
		//字面量   直接量
//		String str = "HelloWorld";
		
		String s1="123abc";
		String s2="123abc";
		String s3="123abc";
		String s4=new String("123abc");
		/*
		 * 修改s1后，s1会创建一个新的字符串对象；
		 * 单独引用，不会影响s2的原有引用；
		 */
//		System.out.println(s1==s2);
//		s1 = s1+"!";
//		System.out.println(s1);
//		System.out.println(s2);
		/*
		 * 使用字面量赋值会重用对象
		 */
		System.out.print(s1==s2);//true
		System.out.print(s1==s3);//true
		System.out.print(s1==s4);//false
	
		/*
		 * 编译器在编译源程序时若发现一个计算表达式
		 * 计算符左右两边的内容是字面量，则会直接将
		 * 计算后的结果编译到class文件中。所以JVM
		 * 看到的样子是:
		 * String s5 = "123abc";
		 */	
		String s5 = "123"+"abc";
		System.out.println(s1==s5);//true
		
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1==s6);//false
		System.out.println(s6);



		
	}
}
