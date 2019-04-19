package a01;

import java.util.Scanner;

/**
 * Fibonacci斐波那契数列 -- 【经典兔子问题】
 * 1.1，1，2，3，5，8，13，21...（兔子怎么生的？）
 * 2.算法：所求月是前两月之和；第一月，第二月都是1
 * 3.
 * 3.month不能过大，超过42+则超过Int范围
 * @author Administrator
 *
 */
public class day06_Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要查询第几月：");
		int month = scan.nextInt();
		int n = rBirth(month);
		System.out.println("第"+ month +"月有兔子"+ n +"对");
		//循环解决
		int f1 = 1, f2 = 1, f ; 
		for(int i = 3; i <= month; i++){
			f = f2;
			f2 = f1 + f2;
			f1 = f;
		}
		if(month == 0){
			f2 = 0;
		}
		System.out.println("有"+ f2 +"对兔子");
	}
	
	//递归法  + 分支解决
	public static int rBirth(int month){
		if(month == 0){
			return 0;
		}else if(month == 1){
			return 1;
		}else{
			return rBirth(month - 1)+ rBirth(month -2);
		}
	}
}
