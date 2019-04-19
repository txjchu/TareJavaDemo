package day01;
/**
 * static String valueOf(...)
 * 字符串提供了一系列的静态方法valueOf()
 * 主要解决将基本类型转换为字符串。
 * 
 * String不是基本类型，是引用类型，适用于面向对象操作。
 * @author Administrator
 *
 */
public class StringDemo011 {
	public static void main(String[] args) {
		int a = 1;
		String s1 = String.valueOf(a);
		System.out.println(a);//1
		System.out.println(s1);//1
		
		System.out.println(s1 + 1);//11
		double d = 1.1;
		String s2 = String.valueOf(d);
		System.out.println(s2 + 1);//1.11
		
		String s3 = a + "";
		System.out.println(s3);//1
	}
}















