package day01;
/**
 * 检测回文
 * @author Administrator
 *
 */
public class StringDemo8 {

	public static void main(String[] args) {
		String str="上海自来水来自海上";
		/**
		 * 思路：
		 * 正数位置上的字符与倒数位置上的字符都一样既是回文；
		 */
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
				System.out.println("不是回文！");
				return;
			}
		}
		System.out.println("是回文！");
	}
}

		/**
		 * boolean tf=true;-----用开关
		 * return false；
		 * if(tf){
		 * System.out.println("是回文！");
		 */
			