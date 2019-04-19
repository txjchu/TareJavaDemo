package day01;
/**
 * Á·Ï°£º½ØÈ¡ÓòÃû
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		/**
		 * www.baidu.com
		 * www.tarena.com.cn
		 */
		
		//			012345678901234567
//		String url="http://www.tedu.cn";
//		String sub=url.substring(11,15);
//		System.out.println(sub);

		String url="http://www.baidu.com";
		int start=url.indexOf(".")+1;
		int end=url.indexOf(".",start);
		String name=url.substring(start, end);
		System.out.println(name);
	}

}
