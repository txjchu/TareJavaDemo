package day02;
/**
 * 和谐用语
 * @author Administrator
 *
 */
public class StringDemo05 {
	public static void main(String[] args) {
		//String字符串完全匹配，包括空白。
//		String regex = "(wqnmlgb | dsb | nmb | cmb | cnnnd | rnm | djb)";
		String regex = "(wqnmlgb|dsb|nmb|cmb|cnnnd|rnm|djb)";
		String message = "wqnmlgb!你这个dsb!cnnnd!你个djb!";
		message = message.replaceAll(regex, "***");
		System.out.println(message);//***!你这个***!***!你个***!

	}
}
