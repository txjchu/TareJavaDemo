package day02;

import java.util.Arrays;
import java.util.Random;

/**
 * 面试题：
 * 有一座高度10级台阶的楼梯，从下往上走，每跨一步只能向上1级或2级台阶。
 * 要求：用程序来求出一共有多少种走法
 * @author Administrator
 *
 */
public class stepDemo {	
	
	//2.使用循环解决
	public int kids(int step){
		int[] arr = new int[]{1, 2};
		if(step == 1){return 1;}
		if(step == 2){return 2;}
		for(int i = 3; i <= step; i ++){
			int n = arr[1];
			arr[1] = arr[1] + arr[0];
			arr[0] = n;
		}
		return arr[1];
	}
	//3.使用递归
	public int count(int step){
		if(step == 1){
			return 1;
		}else if(step == 2){
			return 2;
		}else {
			return count(step - 1) + count(step - 2);
		}
	}
	
	
	
	public static void main(String[] args) {
		/*
		 *  n级台阶数：1  2  3  4  5   6   7   8   9   10  ....
		 * m种走步方法：1  2  3  5  8  13  21  34  55   89  .... 
		 * 所以10级台阶的走步方法为89种。因为每一步的步数为1或2。
		 * 斐波那契数列求第n项的值
		 */
		
		stepDemo s = new stepDemo();
		//2.调用for循环的方法
		int count = s.kids(10);
		System.out.println(count);
		//3.调用递归的方法
		count = s.count(45);//  ========超级费时间
		System.out.println(count);
		
	//1.使用数组解答，缺点：需要额外增加一个数组内存空间开支。	
	int index = 10;	//int类型的最高台阶数为45（1836311903）
	count = 0;
	int[] fibonacci = new int[3];//斐波那契数列
	fibonacci[0] = 1;
	fibonacci[1] = 1 + fibonacci[0];
	fibonacci[2] = fibonacci[2 - 1] + fibonacci[2 - 2];
	for(int i = 3; i < index; i ++){
		fibonacci = Arrays.copyOf(fibonacci, fibonacci.length + 1);
		fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
	}
	//即n级台阶数的走步方式为fibonacci[n-1]种
	count = fibonacci[index - 1];	
	System.out.println(count);
		
		
		
		
/*		
/**
 * 思路不对，下面的是类似面向过程编程的思路。		
 *-/
		
		int[] arr = new int[1];//用于存储每一次走法
		int steeps = 10;//总共有10级台阶
		int sum = 0;//计算一种走法中当前跨越了多少级
		int index = 0;//每一步的下标
		do{
			Random ran = new Random();
			if(sum < steeps + 1){//如果sum小于11
				arr[arr.length - 1] = ran.nextInt(2) + 1;//随机生成每一步跨出的级数
				sum += arr[arr.length - 1];//已经跨了多少级台阶
				
				//当steeps < sum < steeps + 1时，将现arr扩容，
				
				arr = Arrays.copyOf(arr, arr.length + 1);
				
			}else{//如果sum等于11
				arr = Arrays.copyOf(arr, arr.length - 1);//缩容，删除最后一项
				arr[arr.length - 2] = ran.nextInt(2) + 1;
				sum += arr[arr.length - 2];
			}
			System.out.println(Arrays.toString(arr));
			
			
		}while(sum < steeps || (sum == 11 && arr[index - 2] == 2));
/**
 * 1.如何不断的将新的arr放入到arrs中
 * 2.如何不断的产生新的arr(arr数组以台阶数够10结束生成，如何进入下一个arr生成中)
 * 
 * 
 *-/
		//将arr放入arrs中。
		int[][] arrs = new int[1][];
		//判断arr是否包含在arrs中
		boolean flag = false;
		for(int i = 0; i < arrs.length; i ++){
			if(arr.equals(arrs[i])){
				flag = true;
			}
		}
		
		//如果没有包含在arrs中，则放入arrs中。最终arrs.length就是最终结果：多少种走法。
		if(flag == false ){
			arrs[arrs.length - 1] = arr ;//将新元素放入数组的最后一位上
			arrs = Arrays.copyOf(arrs, arrs.length + 1);//将数组扩容，准备放入下一个新arr
		}
		
		//计算总共有多少中走法
		int count = 0;//用于储存总共多少中走法。
		if(arrs[arrs.length - 1] == null){//如果arrs最后扩容完却没有新arr放入，则最后一位元素为null
			count = arrs.length - 1;
		}else{
			count = arrs.length;
		}
		System.out.println("一共有"+ count +"种走法。");
		for(int i = 0; i < arrs.length ; i++){
			System.out.println(Arrays.toString(arrs[i]));
			
		}
*/		
	}
}














