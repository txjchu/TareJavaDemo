package com.tare.shoot;

import java.util.Random;

/** �����������һ������Ԫ�� */
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
