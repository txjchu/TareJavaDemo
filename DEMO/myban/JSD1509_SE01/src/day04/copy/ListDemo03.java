package day04.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start, int end)
 * 获取当前集合的子集
 * @author Administrator
 *
 */
public class ListDemo03 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i ++){
			list.add(i);
		}
		System.out.println(list);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		//取出3-7
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);//[3, 4, 5, 6, 7]
		
		/*
		 * 将子集中每个元素扩大10倍
		 */
		for(int i = 0; i < subList.size(); i ++){
			int n = subList.get(i);
			n = n * 10;
			subList.set(i, n);
		}
		System.out.println(subList);//[30, 40, 50, 60, 70]
		/*
		 * 对子集合的操作会影响原集合对应的元素
		 */
		System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
		list.subList(2, 3).clear();//截取子集合，并删除
		System.out.println(list);//[0, 1, 30, 40, 50, 60, 70, 8, 9]
	}
}










