package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机生成数组
 * 1.封装一个generateArray()方法，生成指定长度，指定范围的一个随机数组
 * 2.调用方法，并输出
 */
public class day06_01_generateArray {
	public static void main(String[] args) {
		int[] a = generateArray(100,10);//调用方法，并接收方法返回的数组
		System.out.println(Arrays.toString(a));//输出结果
	}
	
	
	//1.封装方法
	public static int[] generateArray(int max, int length){ 
		int[] arr = new int[length];//创建指定长度的数组
		for(int i = 0; i < arr.length; i++){
			Random ran = new Random();
			arr[i] = ran.nextInt(max); //生成的数在指定范围内
						//(没有去重复)，如：[1, 7, 5, 0, 7, 5, 7, 4, 6, 4]
		}
		return arr; //方法最终返回数组
	}
	
}
