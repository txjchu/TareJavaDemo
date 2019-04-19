package day01;
/**
 * int indexOf(String str)
 * 查找方法，该方法的作用是：返回给定字符串在当前字符串中的位置。
 * @author Administrator
 *
 */
public class StringDemo03 {
	public static void main(String[] args) {
		//			  0123456789012345	
		String str = "thinking in java";
		/**
		 * 查看当前字符串中第一次出现给定字符串的位置。若没有找到则返回-1。
		 */
		int index = str.indexOf("in");
		System.out.println(index);//2
		/**
		 * 重载方法
		 * int indexOf(String str , int i)
		 * 从给定位置处开始查找给定字符串第一次出现的位置。
		 */
		index = str.indexOf("in", 3);
		System.out.println(index);//5
		
		/** ====重要应用==== */
		/**
		 * 检测一个字符在一个字符串位置之后第一次出现的位置。
		 */
		index = str.indexOf("in");//in第一次出现的位置，
		index = str.indexOf("i", index + "in".length());
		System.out.println("in之后i出现的位置："+ index);//输出：in之后i出现的位置：5
		
		/**
		 * int lastIndexOf(String str)
		 * 查找给定字符串在当前字符串中最后一次出现的位置。
		 */
		index = str.lastIndexOf("in");
		System.out.println(index);
	}
}














