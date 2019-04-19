package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 自己的思路，
 * 双色球
 * 1.产生双色球方法
 * 2.按用户输入个数，调用方法
 * 3.输出
 * @author Administrator
 *
 */
public class day06_doubleBalls {
	public static void main(String[] args) {
		//2.接收用户输入的个数，调用双色球方法
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入双色球个数（0-9）：");
		int nou = scan.nextInt();
		int[] balls = doubleBalls(nou);
		
		scan.close();
		//3.输出
		System.out.println("本次双色球为："+ Arrays.toString(balls));
	}
	//1.生产双色球方法(不能出现相同的数字)
	public static int[] doubleBalls(int n){
		int[] arr = new int[n];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(10);//随机生成0 <= num < 10之间的数
			//去除重复数字
			for(int j = 0; j < i; j++){
				if(arr[i] == arr[j]){
					i --;//----如果arr[i]和之前某个元素相同，则i-1,重新生成arr[i]
					continue;
				}				
			}
		}
		
		return arr;
	}
}
