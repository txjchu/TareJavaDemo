package day01;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否是以给定字符串开头的或结尾的。
 * @author Administrator
 *
 */
public class StringDemo09 {
	public static void main(String[] args) {
		String str = "thinking in java";
		
		boolean starts = str.startsWith("thin");
		System.out.println("starts:"+ starts);//starts:true
		
		boolean ends = str.endsWith("ava");
		System.out.println("ends:"+ ends);//ends:true
	}
}













