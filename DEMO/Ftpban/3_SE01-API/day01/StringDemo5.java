package day01;
/**
 * 练习:截取域名
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		/*
		 * www.baidu.com
		 * www.tarena.com.cn
		 */
		String url = "www.baidu.com.cn";
		
		//起始位置是第一个"."之后的第一个字符的位置
		int start = url.indexOf(".")+1;
		//结束位置是第二个"."的位置
		int end = url.indexOf(".",start);
		String name = url.substring(start, end);
		System.out.println(name);
	}
}




