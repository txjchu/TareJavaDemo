package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 找出一个数组中的最大值，并放到扩容后的数组的最后一个位置
 * 1.创建1个长度为10的随机数数组
 * 2.找出数组中最大值
 * 3.扩容数组，并将最大值放入最后一位
 * 4.输出
 * @author Administrator
 *
 */
public class day05_c03_max {
	public static void main(String[] args) {
		//1.创建数组
		int[] arr = new int[10];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(100);
		}
		System.out.println("生成数组为："+ Arrays.toString(arr));
		//2.找出最大值
		int max = arr[0]; //将最大值初始化为数组中的第一个元素
		for(int i = 1; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		System.out.println("数组中最大值为："+ max);
		//3.扩容新数组，并放入最大值
//		arr = Arrays.copyOf(arr, arr.length + 1); 	Arrays.copyOf()的应用
		int[] arrNew = new int[arr.length + 1];
		System.arraycopy(arr, 0, arrNew, 0, arr.length);
		arrNew[arrNew.length - 1] = max;
		//输出
		System.out.println("新数组为："+ Arrays.toString(arrNew));
	}
}
