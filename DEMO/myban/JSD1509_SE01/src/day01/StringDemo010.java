package day01;
/**
 * toUpperCase()		toLowerCase()
 * 将字符串中的英文部分转换为全小写或者全大写
 * @author Administrator
 *
 */
public class StringDemo010 {
	public static void main(String[] args) {
		String str = "我爱Java";
		/**
		 * String toUpperCase()转换成全大写
		 */
		String upper = str.toUpperCase();
		System.out.println(upper);//我爱JAVA
		/**
		 * String toLowerCase()转换为全小写
		 */
		String lower = str.toLowerCase();
		System.out.println(lower);//我爱java
		
		//该方法常用来判断忽略大小写检查字符串内容
	}
}













