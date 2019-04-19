package day02;
/**
 * String支持正则表达式的相关方法1：
 * boolean matches(String regex)
 * 判断当前字符串是否满足给定的正则表达式的格式要求。
 * 需要注意到是，正则表达式中不管是否有“^”“$”指定，都是全匹配验证。
 * @author Administrator
 *
 */
public class StringDemo01 {
	public static void main(String[] args) {
		String mail = "fancq@tedu.cn";
		/*
		 * 邮箱的正则表达式：\w+@\w+(\.[a-zA-Z]+)+
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 * + 加号表示出现1个或者任意多个
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		String regexNext = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean matches = mail.matches(regex);
		boolean matchesNext = mail.matches(regexNext);
		if(matches){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
		if(matchesNext){
			System.out.println("是邮箱！");
		}else{
			System.out.println("不是邮箱！");
		}
	}
}














