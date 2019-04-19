package day01;
/**
 * 检查回文
 * 
 * @author Administrator
 *
 */
public class StringDemo08 {
	public static void main(String[] args) {
		String str = "上海自来水来自海上";
		/*
		 * 思路：正数位置上的字符与倒数位置上的字符都一样，即是回文。
		 */
		for(int i = 0; i < str.length() / 2; i ++){
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
				System.out.println("不是回文！");
				return;
			}
		}
		System.out.println("是回文！");
		//输出:是回文！
	}
}













