package day01;
/**
 * boolean starts=str.startsWith();
 * boolean ends=str.endsWith();
 * 判断当前字符串是否是以给定字符串开头或者结尾的
 * @author Administrator
 *
 */
public class StringDome9 {
	public static void main(String[] args) {
		String str="thinking in java";
		
		boolean starts=str.startsWith("th");
		System.out.println("starts:"+starts);
 
		boolean ends=str.endsWith("ava");
		System.out.println("ends:"+ends);
	}

}
