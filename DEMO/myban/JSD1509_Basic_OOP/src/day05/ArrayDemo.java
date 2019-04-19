package day05;
import java.util.Arrays;
//数组的演示
public class ArrayDemo {
	public static void main(String[] args) {
		/*
		 * 数组的联系：
		 * 1.声明int型数组arr,包含4个元素
		 * 2.声明int型数组arr1,直接初始化为1，3，5，7
		 *   声明int型数组arr2,new后直接初始化为1，3，5，7
		 * 3.输出arr的长度 
		 *   给arr中第1个元素赋值为100
		 *   输出arr中的最后一个元素的值(下标不能写死)
		 *   arr[4]=200;----------???
		 * 4.创建类MaxOfArray，在main()中:
		 *   声明int型数组arr，包含10个元素
		 *   循环方式给arr中的每个元素赋值为0到99间的随机数
		 *   输出arr中每个元素的值
		 *   
		 */
		
		int[] arr=new int[4];
		int[] arr1={1,3,5,7};
		int[] arr2=new int[]{1,3,5,7};
		System.out.println(arr[arr.length]);
		
		arr[0]=100;
		System.out.println(arr[arr.length-1]);
	
		//arr[4]=200;
		
		// 6.数组的复制
		int[] a={10,20,30,40,50};
		int[] a1=new int[6];//0,0,0,0,0,0
		//a:源数组
		//1:源数组的起始下标
		//a1:目标数组
		//0:目标数组的起始下标
		//4:要复制的元素的个数
		System.arraycopy(a,1,a1,0,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		
		
		/*
		//5.数组的遍历
		int[] arr=new int[10];
		
		*/
		
		/*
		//4.数组的访问
		System.out.println(arr.length);//3
		System.out.println(arr[0]);//0
		arr[0]=100;
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;//-----错误
		arr[arr.length-1]=
		*/
		
		/*
		//2.数组的初始化
		int[] arr=new int[3];
		int[] arr1={2,5,8};
		int[] arr2=new int[]{2,5,8};
		int[] arr3;
		//arr3=
		int[] arr4=
		*/
		/*
		//1.数组的定义
		int[] arr=new int[4];
		*/
		
	}

}
