package day03;

import java.util.Arrays;

//排序	将给定的3个数字按从小到大顺序排列	冒泡排序
public class Max {
	public static void main(String[] args) {
		int[] arr = new int[11];
		for(int i = 0; i < arr.length; i ++){
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length - 1; i ++){
			for(int j = 0; j < arr.length - 1 - i; j ++){
				if(arr[j] > arr[j + 1]){
					int max = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = max;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
/*  compilations  insufficient
		int max;
		for(int i = 0; i < 5; i ++){
			a = (int)(Math.random() * 10);
			b = (int)(Math.random() * 10);
			c = (int)(Math.random() * 10);
			System.out.print(a +","+ b +","+ c +"====");
			
			if(a > b){
				max = a;
				a = b;
				b = max;
			}
			if(a > c){
				max = a;
				a = c;
				c = max;
			}
			if(b > c){
				max = b;
				b = c;
				c = max;
			}
			System.out.println(a +","+ b +","+ c);
			
		}
*/		
	}
}













