package day01;
/**
 * String substring(int start,int end)
 * 截取字符串
 * 从start指定的位置截取到end指定的位置(不含end)
 * java API有一个特点，通常情况下使用两个数字表示
 * 一个范围时都是含头不含尾的。
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		//            01234567890123
		String str = "www.oracle.com";
		//截取oracle
		String sub = str.substring(4, 10);
		System.out.println(sub);
		
		/*
		 * 重载方法:
		 * String substring(int start)
		 * 从指定位置开始连续截取到字符串末尾
		 */
		sub = str.substring(4);
		System.out.println(sub);
		
		
		
	}
}






