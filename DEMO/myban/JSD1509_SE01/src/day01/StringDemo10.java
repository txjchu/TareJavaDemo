package day01;
/**
 * toUpperCase()----toLowerCase()
 * 将字符串中英文部分转换为全大写或者全小写
 * @author Administrator
 *
 */
public class StringDemo10 {
	public static void main(String[] args) {
	String str="我爱Java!";	
	/**
	 * String toUpperCase()
	 * 英文部分全大写
	 */
	String upper=str.toUpperCase();
	System.out.println(upper);
	
	String lower=str.toLowerCase();
	System.out.println(lower);

	//该方法常用来判忽略大小写检查字符串内容
	}
}
