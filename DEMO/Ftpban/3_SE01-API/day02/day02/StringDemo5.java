package day02;
/**
 * ��г����
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		String regex = "(wqnmlgb|dsb|nmb|cmb|cnm|cnnnd|rnm|djb)";
		String message = "wqnmlgb!�����dsb!cnnnd!���djb!";
		message = message.replaceAll(regex, "****");
		System.out.println(message);
	}
}







