package day02;
/**
 * ��г����
 * @author Administrator
 *
 */
public class StringDemo05 {
	public static void main(String[] args) {
		//String�ַ�����ȫƥ�䣬�����հס�
//		String regex = "(wqnmlgb | dsb | nmb | cmb | cnnnd | rnm | djb)";
		String regex = "(wqnmlgb|dsb|nmb|cmb|cnnnd|rnm|djb)";
		String message = "wqnmlgb!�����dsb!cnnnd!���djb!";
		message = message.replaceAll(regex, "***");
		System.out.println(message);//***!�����***!***!���***!

	}
}
