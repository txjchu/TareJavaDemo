package day01;
/**
 * 字符串拼接的效率问题以及资源消耗
 * @author Administrator
 *
 */
public class StringDemo12 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<10000000;i++){
			str += str;
		}
		
	}
}
