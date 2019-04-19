package a01;

import java.util.Scanner;

//求数列和
public class day04_09_02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数（如11）：");
		long n = scan.nextLong();//将用户输入的数字存入a中
		scan.close();
		double sum = 0.0;
		for(long i = 1; i < n; i++){		//----不能i<=n。
			sum = sum + 1.0 / i;
//			if(i == 1){
//				System.out.print(i);
//			}else{
//				System.out.print("+1/"+ i);
//			}
			if(i == 1){
				System.out.print("1+");
			}else{
				System.out.print("1/"+ i +"+");
			}
		}
		sum += 1.0 / n;
		System.out.println("1/"+ n +"="+ sum );//----输出写死则输出错误

	}
}

/**
 *package a01;
//输出打印数列和过程
public class ab {
	public static void main(String[] args) {
		int result = 0;
//		System.out.print("1+");
		for(int i = 1; i < 10; i++){
			result += i;
//			if(i == 9){
//				System.out.print(i);
//			}else{
//				System.out.print(i +"+");				
//			}
			if(i == 1){
				System.out.print(i);
			}else{
				System.out.print("+"+ i);
			}
		}
		System.out.println("="+ result);
	}
}

 * 
 */

