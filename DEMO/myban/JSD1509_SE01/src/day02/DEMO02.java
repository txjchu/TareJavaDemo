package day02;

import java.util.Arrays;

/** 练习 */
public class DEMO02 {
	public static void main(String[] args) {
		
		
		
	/**
		String str = "abc,def,hig,asda,dfg";
		/*
		 * 若出现连续匹配项，则中间会拆分出一个空字符串，但是在字符串末尾的连续匹配则会被忽略。
		 *=/
		String[] arr = str.split(",");
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i]);
		}
	*/	
	/**
		String mail = "fancq@tedu.cn";
		/*
		 * 邮箱的正则表达式
		 * ^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+$
		 *=/
		String regex = "^[a-zA-Z0-9_\\.]+@[0-9a-zA-Z_]+(\\.[a-zA-Z0-9]+)+$";
		boolean  matches = mail.matches(regex);//调用matches(regex)方法验证字符串是否符合某正则表达式
		if(matches){
			System.out.println("是邮箱！");
		}else{
			System.out.println("不是邮箱！");
		}
	*/	
	}
	

}








