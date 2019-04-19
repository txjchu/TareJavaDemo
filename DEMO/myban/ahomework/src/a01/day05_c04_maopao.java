package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 1.创建一个长度为10的随机数组
 * 2.从小到大排序，并输出过程
 * 3.输出结果
 * @author Administrator
 *
 */
public class day05_c04_maopao {
	public static void main(String[] args) {
		//1.创建随机数组
		int[] arr = new int[10];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));//输出原始数组
		System.out.println("--------冒泡排序 开始--------");
		//2.冒泡排序，并输出过程
		for(int i = 0; i < arr.length - 1; i ++){
			for(int j = 0; j < arr.length - 1 - i; j ++){
				if(arr[j] > arr[j + 1]){	//★	>升序排列，<降序排列
					int max = arr[j];
					arr[j]= arr[j + 1];
					arr[j + 1] = max; 
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("--------冒泡排序 结束--------");
		System.out.println(Arrays.toString(arr));
	}
}
