package day01;
/**
 * 检测回文
 * @author Administrator
 *
 */
public class StringDemo8 {
	public static void main(String[] args) {
		String str = "上海自来水来海自上";
		/*
		 * 思路:
		 * 正数位置上的字符与倒数位置上的字符都一样
		 * 既是回文。
		 */
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=
			   str.charAt(str.length()-1-i)){
				System.out.print("不是回文!");
				return;
			}
		}
		System.out.println("是回文!");
	}
}



