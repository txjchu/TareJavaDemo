package day02;
/**
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足给定正则表达式的部分替换为指定的字符串内容
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		String str="aaa111bbb222ccc333ddd4444eee";
		/*
		 * 将数字部分替换为“#NUMBER#”
		 */
		str=str.replaceAll("[0-9]+","#NUMBER#");//----+表示替换一次，如果没有加号则替换3次
		System.out.println(str);
	}
}
