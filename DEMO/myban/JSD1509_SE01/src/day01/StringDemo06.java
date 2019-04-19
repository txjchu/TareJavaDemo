package day01;
/**
 *	String trim()去除字符串两边的空白 
 * @author Administrator
 *
 */
public class StringDemo06 {
	public static void main(String[] args) {
		String str = "   Hello 			  ";
		System.out.println(str);//输出的是“   Hello 			  ”
		String trim = str.trim();//去除空白
		System.out.println(trim);//输出的是“Hello”
	}
}













