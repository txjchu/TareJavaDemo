package day02;
/**
 * ºÍĞ³ÓÃÓï
 * 
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		String regex="(wqnmlgb|dsb|nmb|cmb|cnm|cnnnd|rnm|djb)";
		String message="wqnmlgb!ÄãÕâ****";
		message = message.replaceAll(regex, "****");
		
		System.out.println(message);
		
	}
}
