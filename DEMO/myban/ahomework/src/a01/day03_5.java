package a01;

import java.util.Scanner;
//判断闰年

public class day03_5 {
	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入年份（如：2016）：");
//		int year = scan.nextInt();
//		scan.close();
//		/**
//		 * 判断闰年需要满足2个条件中的其中1条：
//		 * 1.能被4整除且不能被100整除
//		 * 2.能被400整除
//		 */
//		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
//			//1、逻辑判断是建立在关系判断之上的。
//			//2、||(或)和&&(且)都有短路现象，当第一个条件就可以判断出整个逻辑判断表达式的结果时，后面的条件则不再进行运算。
//			System.out.println(year+"年是闰年。");
//		}else{
//			System.out.println(year+"年不是闰年。");
//		}
//		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		scan.close();
		String msg = year %400 == 0 || (year % 4 == 0 && year % 100 != 0) ? year +"是闰年" : year +"不是闰年";
		System.out.println(msg);
	}
}	
