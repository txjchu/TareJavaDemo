package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 求数组中最大数
 * @author Administrator
 *
 */
public class day05_c02_max {
	public static void main(String[] args) {
		int[] arr = new int[10];//创建一个长度为10的数组
		int max = 0;
		//随机生成10个0~99之间的数字，放入数组
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int) (Math.random()*100);
			arr[i] = ran.nextInt(100);
			if(max < arr[i]){//计算出数组中最大值
				max = arr[i];
			}
		}
		//输出数组，输出最大值
		System.out.println(Arrays.toString(arr));
		System.out.println("数组中最大值为："+ max);
	}
}
