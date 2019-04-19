package a01;

import java.util.Arrays;

/**
 * 查询数组中最小数，并扩容为新数组
 * 1.创建数组arr[]
 * 2.找出数组中最小数
 * 3.创建新数组，并将最小数与arr[]填充
 * @author Administrator
 *
 */
public class day05_04 {
	public static void main(String[] args) {
		int[] arr = new int[10];//1.创建arr[]数组，每个数组元素随机生成
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int) (Math.random()* 100);
		}
		System.out.println("数组中的数据为："+ Arrays.toString(arr));
		int min = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		System.out.println("数组中最小数为："+ min);
//		for(int j = 0; j < arr.length-1; j++){
//			for(int i = arr.length - 1; i > 0; i--){//2.计算数组中最小数
//				if(arr[i] < arr[i-1]){
//					int min ;
//					min = arr[i-1];
//					arr[i-1] = arr[i];
//					arr[i] = min;
//				}
//			}
//		}
		int[] arrNew = new int[arr.length + 1];//3.创建新数组,--注意此处新数组的长度
		System.arraycopy(arr, 0, arrNew, 1, arr.length);
		arrNew[0] = min;
		System.out.println("新数组中的数据为："+ Arrays.toString(arrNew));
//		for(int i = 0; i < arrNew.length; i++){
//			System.out.print(arrNew[i] +" ");
//		}
	}
}
