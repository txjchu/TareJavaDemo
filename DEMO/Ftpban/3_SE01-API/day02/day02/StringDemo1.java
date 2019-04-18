package day02;
/**
 * String支持正则表达式的相关方法1:
 * boolean matches(String regex)
 * 判断当前字符串是否满足给定的正则表达式
 * 的格式要求。需要注意，正则表达式中不管
 * 是否有"^","$"指定，都是全匹配验证！
 * @author Administrator
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String mail = "fancq@tedu.cn";
		/*
		 * 邮箱的正则表达式:
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		
		boolean matches = mail.matches(regex);
		
		if(matches){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
	}
}







