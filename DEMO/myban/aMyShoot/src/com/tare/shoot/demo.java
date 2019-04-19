package com.tare.shoot;

import java.util.Random;

/** 测试随机生成一个数组元素 */
public class demo {
	public static void main(String[] args) {
		int[] a = {0 , 1};
		Random ran = new Random();
//		for(int i = 0; i < 10; i ++){
//			int b = a[ran.nextInt(1)];
//			System.out.print(b);
//		}
		System.out.println(a[ran.nextInt(2)]);
	}
	
}
