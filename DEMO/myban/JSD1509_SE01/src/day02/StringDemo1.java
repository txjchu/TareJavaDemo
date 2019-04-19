package day02;
/**
 * String支持正则表达式的相关方法1：
 * boolean matches(String regex)
 * 判断当前字符串是否满足给定的正则表达式的格式要求。
 * 需要注意的是，正则表达式中不管是否有“^”，“$”指定，都是全匹配验证！★
 * @author Administrator
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String mail="fancq@tedu.cn";
		/*
		 * 邮箱的正则表达式：
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+[\.[a-zA-Z]+)+
		 */
		String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";//-----\.想在Java中表示，前面再加\
		//-----Java中默认前后符号^……$,完全匹配
		boolean matches=mail.matches(regex);
		
		if(matches){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
		String emailRegEx = "^[a-zA-Z0-9_.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
		String email = "bjliyi@tarena.com.cn";
		System.out.println(email.matches(emailRegEx));
		
		
		String regex1 = "\\w{8,10}";
		String str1 = "abcd24_abcd";//----8个true，10个true,
		System.out.println(str1.matches(regex1));
		
	}
	public void email(){
//		String emailRegEx = "^[a-zA-Z0-9_.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
//		String email = "bjliyi@tarena.com.cn";
//		System.out.println(email.matches(emailRegEx));
	}
}
