package day02;
/**
 * 和谐用语
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		String regex = "(wqnmlgb|dsb|nmb|cmb|cnm|cnnnd|rnm|djb)";
		String message = "wqnmlgb!你这个dsb!cnnnd!你个djb!";
		message = message.replaceAll(regex, "****");
		System.out.println(message);
	}
}







