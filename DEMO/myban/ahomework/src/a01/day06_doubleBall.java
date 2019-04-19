package a01;

import java.util.Arrays;
import java.util.Random;
/**
 * 双色球，不使用方法
 * @author Administrator
 *
 */
public class day06_doubleBall {
	public static void main(String[] args) {

		String[] pool = { "01", "02", "03", "04", "05", "06","07","08",// 彩球池
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31", "32", "33" };
		boolean[] used = new boolean[pool.length];// 判断球是否使用过数列，用过则改默认值false为true
		String[] balls = { null, null, null, null, null, null };// 取出的彩球号
		Random ran = new Random();
		int i = 0;
//		while (true) {
//			int n = ran.nextInt(pool.length);
//			if (used[n]) {
//				continue;
//			}
//			balls[i++] = pool[n];
//			used[n] = true;
//			if (i == balls.length) {
//				break;
//			}
//		}
//===============================================
//自己的思路
		 for(int j = 0; j < 6; j++){
//			 do{
			 i = ran.nextInt(pool.length);
		 	 if(used[i] == true){//在给balls[j]中元素赋值前先判断pool[i]是否使用过
		 		 j--;			 //如果使用过，则将j-1,不让跳过balls[j]
		 		 continue;
		 	 }
			 balls[j] = pool[i];
			 used[i] = true;
//			 }while(used[i] == true);	//如果while条件为真，则执行do语句块
		 }
//===============================================
		Arrays.sort(balls);	//====将6个球排序，String[] balls可以用Arrays.sort()排序？如果数组中有null，则排序报错
		System.out.println(Arrays.toString(balls));
	}
}
