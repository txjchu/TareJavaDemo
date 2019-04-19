package day02;
/**
 * 拆分字符串
 * String[] split(String regex)
 * 将当前字符串中满足正则表达式的部分“切掉”，保留剩余的每段内容；
 * @author Administrator
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str="abc,,def,,,hig,asda,dfg";//-----如果中间是.的话，下面用\\.,两个,的话，会多出一个空站位字符串
		/*
		 * 若出现连续匹配项，中间会拆分出一个空字符串，但是在字符串末尾连续匹配则会被忽略！
		 */
		String[] arr=str.split(",");
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}		
	}
}
