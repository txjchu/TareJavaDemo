package day01;
/**
 * int indexOf(String str)
 *查找方法，该方法的作用是：
 *返回给定字符串在当前字符串中的位置。
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		//			  0123456789012345
		String str = "thinking in java";
		/*
		 * 查看当前字符串中第一次出现给定字符串的位置，若没有找到则返回-1；
		 */
		int index=str.indexOf("in");//In,严格区分大小写
		System.out.println(index);//打印出2
		
		int k = str.indexOf("k");
		System.out.println(k);
		/*
		 * 重载方法
		 * int indexOf(String str,int i)
		 * 从给定位置处开始查找给定字符串第一次出现的位置。
		 */
		index=str.indexOf("in",3);
		System.out.println(index);
		/**
		 * int lastIndexOf(String str)
		 * 查找给定字符串在当前字符串中最后一次出现的位置
		 */
		index=str.lastIndexOf("in");
		System.out.println(index);
	}

}
