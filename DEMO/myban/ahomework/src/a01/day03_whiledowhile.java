package a01;

import java.util.Scanner;
//while 与 do...while 比较
public class day03_whiledowhile {
	public static void main(String[] args) {
		// while语句
//		Scanner scan = new Scanner(System.in);
//		int pwd = 0;
//		while(123 != pwd){
//			System.out.println("请输入密码：");
//			pwd = scan.nextInt();
//		}
//		System.out.println("欢迎进入！");
		
		//do...while语句
		Scanner scan = new Scanner(System.in);
		int pwd ;
		do{
			System.out.println("请输入密码：");
			pwd = scan.nextInt();
		}while(123 != pwd);
		System.out.println("密码正确，欢迎进入");
		
		/**
		 * while和do-while语句的区别
			while与do-while都是用于执行循环结构的语句，区别在于，while循环先判断再执行，
			而do-while循环先执行一次，再判断。那么，当初始情况不满足循环条件时，
			while循环就一次都不会执行，而do-while循环不管任何情况都至少会执行一次。
			注意：while和do-while语句的不同仅仅体现在第一次就不满足条件的循环中；
			如果不是这样的情况，while与do-while可以互换。
			
			★：此处pwd初始化为关键点。当while语句中pwd初始化为123时，boolean表达式为false,
			则直接输出“欢迎进入”，而不会运行while语句中的程序。
		 */
	}

}
