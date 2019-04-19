package day01;
/**
 * String trim()
 * @author Administrator
 *
 */
public class StringDemo6 {
	public static void main(String[] args) {
		String str="   Hello		";//×ó±ß3¸ñ¿Õ¸ñ£¬ÓÒ±ß2¸öTABÕ¾Î»·û
		System.out.println(str);
		String trim=str.trim();
		System.out.println(str.length());
		System.out.println(trim);
		System.out.print(str.length());
	}

}
