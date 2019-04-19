package day02.copy;

import java.util.Scanner;

/**
 * 计算器。。。- -!
 * @author Administrator
 *
 */
public class 计算器 {
	static String num1;
	static String num2;
	static Scanner getNumber;//获取用户输入
	static boolean flagtoopen = false;
	public static void main(String[] args) {
		int a = 25702;
		Integer b = Integer.valueOf(25702);
		System.out.println(b == a);//true	???
		
		
//		计算器 计算器 = new 计算器();
		getNumber = new Scanner(System.in);//接收用户输入
		System.out.println("亲，欢迎来到计算器！第一个数字是：");
		num1 = getNumber.next();
		if(num1.matches("\\d+")){
			System.out.println("第二个数是：");
		}else{
			System.out.println("输入错误！请输入整数：");
		}
		num2 = getNumber.next();
		if(num2.matches("\\d+")){//判断
			System.out.println("结果是"+ (Integer.parseInt(num1) + Integer.parseInt(num2)));
			
		}else{
			System.out.println("输入错误！请输入整数：");
		}
	}
}
