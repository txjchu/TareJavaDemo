package day01;
/**
 * static String valueOf(...)
 * 字符串提供了一系列的静态方法valueOf()
 * 主要解决将基本类型转换为字符串。
 * @author Administrator
 *
 */
public class StringDemo11 {
	public static void main(String[] args) {
		int a = 1;
		String s1 = String.valueOf(a);
		
		System.out.println(s1+1);
		
		double d = 1.1;
		String s2 = String.valueOf(d);
		System.out.println(s2+1);
		
		String s3 = a+"";
		
	}
}







