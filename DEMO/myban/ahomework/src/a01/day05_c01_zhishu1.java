package a01;

import java.util.Scanner;

/**
 * 用交互方式，输出一个范围内的所有质数
 * 1.判断是否为质数
 * 2.接收用户输入的范围
 * 3.输出结果
 * @author Administrator
 *
 */
public class day05_c01_zhishu1 {
	public static void main(String[] args) {
//		int num = 100;
		System.out.println("请输入范围，2~");
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		int count = 0;
		for(int j = 2; j <= max; j++){
			boolean isPrime = true;//是否为质数
			int m = (int) Math.sqrt(j);
			for(int i = 2; i <= m; i++){//1.判断是否为质数【平方根法】,i必须<=m
				if(j % i == 0){
					isPrime = false;
//					System.out.print(isPrime);
					break;
				}
			}		
			if(isPrime){//3.输出
				count ++;
				System.out.print(j +" ");	
				while(count % 10 == 0){
					System.out.println();
				}
			}
		}
		scan.close();
		System.out.println("\r"+"范围内共有"+ count +"个质数");
	}
}
