package day01;
/**
 * char charAt(int index)
 * 返回当前字符串给定位置对应的字符
 * @author Administrator
 *
 */
public class StringDemo07 {
	public static void main(String[] args) {
		//			  0123456789012345
		String str = "thinking in java";
		
		char c = str.charAt(9);
		char c1 = str.charAt(10);
		char c2 = str.charAt(11);
		System.out.println(""+ c1 + c2 + c);//输出“n i”
	}
}






