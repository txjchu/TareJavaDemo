package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 冒泡算法
 * 1.自动生成数组
 * 2.冒泡排序（并输出过程）
 * 3.输出最终结果
 * @author Administrator
 *
 */
public class aaa_maopao {
	public static void main(String[] args) {
		//1.自动生成数组
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入数组的元素数量（0~100）：");
		int count = scan.nextInt();//数组的元素个数
		System.out.println("请输入数字的最大范围（0~1000）：");
		int max = scan.nextInt();//数组元素的最大范围
		int[] arr = new int[count];//存储自动生成的数组
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * max);
		}
		System.out.println(Arrays.toString(arr));//输出原数组
		//2.排序
		System.out.println("----------冒泡排序开始----------");
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - 1 - i; j++){
				if(arr[j + 1] < arr[j]){
					int num = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = num;
				}
			}
			System.out.println(Arrays.toString(arr));	
		}
		//3.输出最终结果
		int[] arrNew = Arrays.copyOf(arr, arr.length + 1);
		arrNew[arrNew.length - 1] = arr[arr.length - 1];
		System.out.println("----------冒泡排序结束----------");
		System.out.println(Arrays.toString(arrNew));//输出最终结果
		scan.close();
	}
//	求数组中的最大值
//	public static void main(String[] args) {
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++){
//			Random ran = new Random();
//			arr[i] = ran.nextInt(100);
//			System.out.print(arr[i]+ " ");
//		}
//		System.out.println();
//		int max = 0 ;
//		for(int i = 0; i < arr.length ; i++){
//			if(max < arr[i]){
//				max = arr[i];
//			}
//		}
//		System.out.print(max);
//	}
}
