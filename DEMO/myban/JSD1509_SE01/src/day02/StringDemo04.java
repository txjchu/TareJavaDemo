package day02;
/**
 * String replaceAll(String regex, String str)
 * 将当前字符串中满足给定正则表达式的部分替换为指定的字符串内容。
 * @author Administrator
 *
 */
public class StringDemo04 {
	public static void main(String[] args) {
		String str = "aaa111bbb222ccc333ddd444eee";
		/*
		 * 将数字部分替换为“#NUMBER#”
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
	}
}








