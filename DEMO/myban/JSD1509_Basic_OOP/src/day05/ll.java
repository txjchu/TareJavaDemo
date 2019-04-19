package day05;

import java.util.Arrays;
import java.util.Random;

public class ll {

	public static void main(String[] args) {
		int[] arr=new int[10];
		Random ran = new Random();
		for(int i=0;i<arr.length;i++){
			arr[i] = ran.nextInt(100);
		}
		System.out.println(Arrays.toString(arr)); 
	}

}
