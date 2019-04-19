package a01;

import java.util.Scanner;
//比较用户输入的3个数字，并按大小排列
public class day03_4 {
	public static void main(String[] args) {
//		//比较用户输入的3个数字的大小
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入3个数字（数字中间用空格隔开）：");
//		int a1 = scan.nextInt();
//		int a2 = scan.nextInt();
//		int a3 = scan.nextInt();
//		System.out.println("您输入的三个数字是：a="+a1+"，b="+a2+"，c="+a3);
//		int b1 = a1 > a2 ? a1 : a2;
//		int b2 = b1 > a3 ? b1 : a3;
//		System.out.println("三个数字中最大值为："+b2);
		
		//比较用户输入的3个数字并进行排列
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入3个数字（数字用空格隔开）：");
		int a1 = scan.nextInt();
		int a2 = scan.nextInt();
		int a3 = scan.nextInt();
		scan.close();
		System.out.println("您输入的三个数字是：a="+a1+",b="+a2+"，c="+a3);
//		int b1 = a1 > a2 ? a1 : a2;
//		int b2 = b1 > a3 ? b1 : a3;
//		System.out.println(b1);----变量定义后一定要初始化，不然异常
		if(a1 < a2){
			int b1 = 0;			
			b1 = a2 ;
			a2 = a1 ;
			a1 = b1 ;
		}
		if(a1 < a3){
			int b2 = 0;
			b2 = a3;
			a3 = a1;
			a1 = b2;
		}
		if(a2 < a3){
			int b3 = 0;
			b3 = a3;
			a3 = a2;
			a2 = b3;
		}
		System.out.println("三个数字按照从小到大的顺序是：a="+a3+",b="+a2+",c="+a1);
			
		
	}
}
