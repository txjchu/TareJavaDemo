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
public class day05_c01_zhishu {
	public static void main(String[] args) {
		System.out.println("请输入范围2~" );
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();//2.接收用户输入的范围
		System.out.println(num);
		int count = 0;
		for(int j = 2; j <= num; j++){		//判断范围内的每一个数
			boolean isPrime = true;
			for(int i = 2; i < j/2; i++){//1.判断某个数是否为质数【2分法】
				if(j % i == 0){
					//不是质数
					isPrime = false;
					break;
				}
			}		
			if(isPrime){					
				//是质数
				count ++;
				System.out.print(" "+ j);//3.输出单个质数
					while(count % 10 == 0){
						System.out.println();
						break;
					}
			}
	}
		scan.close();
		System.out.println("范围内共有"+ count +"个质数");
	}
}
