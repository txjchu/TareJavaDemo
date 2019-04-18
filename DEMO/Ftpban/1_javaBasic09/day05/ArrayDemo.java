package day05;
import java.util.Arrays;
//数组的演示
public class ArrayDemo {
	public static void main(String[] args) {
		/*
		 * 数组的练习:
		 * 1.声明int型数组arr，包含4个元素
		 * 2.声明int型数组arr1，直接初始化为1,3,5,7
		 *   声明int型数组arr2，new后直接初始化为1,3,5,7
		 * 3.输出arr的长度
		 *   给arr中第1个元素赋值为100
		 *   输出arr中的最后一个元素的值(下标不能写死)
		 *   arr[4]=200;----------???
		 * 4.创建类MaxOfArray，在main()中:
		 *     声明int型数组arr，包含10个元素
		 *     循环方式给arr中的每个元素赋值为0到99间的随机数
		 *     输出arr中每个元素的值
		 */
		//7.数组的排序
		int[] arr = {20,13,3,6,2,45,32,36,234,21};
		for(int i=0;i<arr.length-1;i++){ //控制轮
			for(int j=0;j<arr.length-1-i;j++){ //控制每轮比的次数
				if(arr[j]>arr[j+1]){ //每次都和它的下一个元素比
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		/*
		 * i=0
		 *   j=0 arr0和arr1
		 *   j=1 arr1和arr2
		 *   j=2 arr2和arr3
		 *   j=3
		 * i=1
		 *   j=0 arr0和arr1
		 *   j=1 arr1和arr2
		 *   j=2
		 * i=2
		 *   j=0 arr0和arr1
		 *   j=1
		 */
		
		
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		
		/*
		int[] arr = {100,34,2,36,86,4};
		Arrays.sort(arr); //对arr升序排
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		/*
		//6.数组的复制
		int[] a = {10,20,30,40,50};
		//创建一个新数组，只是名字叫a(数组的扩容)
		a = Arrays.copyOf(a,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		*/
		
		/*
		int[] a = {10,20,30,40,50};
		//a:源数组
		//a1:目标数组
		//6:目标数组的元素个数
		int[] a1 = Arrays.copyOf(a,6);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		/*
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6]; //0,0,0,0,0,0
		//a:源数组
		//1:源数组的起始下标
		//a1:目标数组
		//0:目标数组的起始下标
		//4:要复制的元素的个数
		System.arraycopy(a,1,a1,0,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		/*
		//5.数组的遍历
		int[] arr  = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		/*
		//4.数组的访问
		int[] arr = new int[3];
		System.out.println(arr.length); //3
		System.out.println(arr[0]); //0
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		//arr[3] = 400; //数组下标越界异常ArrayIndexOutOfBoundsException
		System.out.println(arr[arr.length-1]);
		*/
		
		/*
		//2.数组的初始化
		int[] arr = new int[3];        //0,0,0
		int[] arr1 = {2,5,8};          //2,5,8
		int[] arr2 = new int[]{2,5,8}; //2,5,8
		int[] arr3;
		//arr3 = {2,5,8}; //编译错误，此方式只能声明同时初始化
		arr3 = new int[]{2,5,8}; //正确
		*/
		
		/*
		//1.数组的定义
		int[] arr = new int[4];
		*/
	}
}










