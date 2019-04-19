package a01;
//计算输入的2个数字的大小
import java.util.Scanner;

public class yunsuan_day03 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入两个数字（以空格隔开）：");
//		int a1 = scan.nextInt();
//		int a2 = scan.nextInt();
//		scan.close();
//		int a3 = a1>a2 ? a1 : a2;
//		System.out.println("数字中最大值为："+a3);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入两个数字，用空格隔开：");
		int a1 = scan.nextInt();
		int a2 = scan.nextInt();
		scan.close();
		int a3 = a1 > a2 ? a1 : a2;
		System.out.println("两个数字中最大值为："+a3);
		
	}
}
