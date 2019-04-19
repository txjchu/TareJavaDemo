package day05;

import java.util.Arrays;

public class MaxOfArray {

	public static void main(String[] args) {
		
		//7.数组的排序
		int[] arr={100,34,2,36,86,4};
		
		
		/*
		int[] arr=new int[10];
		
		for (int i=0;i<arr.length;i++){          //-------【i=0】
			arr[i]=(int)(Math.random()*100);     //-------赋值1-100直接随机数
			System.out.println(arr[i]);
		}

		int max=arr[0];//假设第一个元素为最大值
		for(int i=1;i<arr.length;i++){//遍历
			if(arr[i]>max){//若剩余元素大于max
				max=arr[i];//修改max为较大的值
			}
		}
		System.out.println("最大值为："+max);
		
		arr=Arrays.copyOf(arr,arr.length+1);//
		arr[arr.length-1]=max;//将max赋给数组的最后一位
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		

		
		*/
		
		
		/*
		int[] arr=new int[10];
		
		for (int i=1;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);     //-------赋值1-100直接随机数
			System.out.println(arr[i]);
		}

		int max=arr[0];//假设第一个元素为最大值
		for(int i=1;i<arr.length;i++){//遍历
			if(arr[i]>max){//若剩余元素大于max
				max=arr[i];//修改max为较大的值
			}
		}
		System.out.println("最大值为："+max);
		*/
	}

}
