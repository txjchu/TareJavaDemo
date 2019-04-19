package day01;
/**
 * String substring(int start, int end)
 * 截取字符串方法
 * 从start指定位置截取到end指定位置（含头不含尾），返回截取到的字符串。
 * @author Administrator
 *
 */
public class StringDemo04 {
	public static void main(String[] args) {
		//			  01234567890123	
		String str = "www.oracle.com";
		//截取oracle
		String sub = str.substring(4,10);//含头不含尾
		System.out.println(sub);//oracle
		/**
		 * 重载方法
		 * String substring(int start)
		 * 从指定位置开始连续截取到字符串末尾。
		 * 
		 */
		sub = str.substring(4);
		System.out.println(sub);//oracle.com
	}
}












