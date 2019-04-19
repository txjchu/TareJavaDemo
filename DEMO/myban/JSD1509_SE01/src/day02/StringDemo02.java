package day02;
/**
 * 拆分字符串
 * String[] split(String regex)
 * 将当前字符串中满足正则表达式的部分“切掉”，保留剩余的每段内容，并以字符串数组的方式保存返回。
 * @author Administrator
 *
 */
public class StringDemo02 {
	public static void main(String[] args) {
		String str = "abc,def,hig,,asda,dfgas,asdf,ao";
		/*
		 * 若出现连续匹配想，中间会拆分出一个空字符串。但是在字符串末尾的连续匹配则会被忽略。
		 */
		String[] arr = str.split(",");
		System.out.println(arr.length);//8
		for(int i = 0; i < arr.length; i ++){
			System.out.println(arr[i]);
		}
	}
}


















