package a01;

import java.util.Scanner;

//计算出用户输入的3个整数中的最大值
public class day03_08_MaxOfThree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入3个整数a,b,c（以空格隔开）：");
		//接收用户输入的3个整数
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		
		int result = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		System.out.println("最大值为"+ result);
		
//		int d = a > b ? a : b;
//		int e = d > c ? d : c;
//		System.out.println("最大数为"+ e);
	}

}
