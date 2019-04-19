package a01;

import java.util.Arrays;

//Ã°ÅÝÁ·Ï°
public class aa02 {
	public static void main(String[] args) {
		int[] arr = {99, 87, 44, 33, 49, 80};
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - 1 - i; j++){
				int max ;
				if(arr[j] > arr[j + 1]){
					max = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = max;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
}
