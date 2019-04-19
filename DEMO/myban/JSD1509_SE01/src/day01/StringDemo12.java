package day01;
/**
 * 字符串拼接的效率问题以及资源消耗
 * @author Administrator
 *
 */
public class StringDemo12 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<23;i++){// i最多可以设置为小于23，输出：8388608
			str += str;
			//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		}
		System.out.println(str.length());//当i=10时，str.length()=1024;
	}
}
