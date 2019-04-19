package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 排序一个集合需要使用集合的工具类Collections.其提供了一个静态方法sort()，可以用来排序集合。
 * 需要注意的是，排序只能排序List集合，因为Set集合的实现不都是有序的。
 * @author Administrator
 *
 */
public class SortListDemo01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random ran = new Random();
		for(int i = 0; i < 10; i ++){
			list.add(ran.nextInt(100));
		}
		//打桩
		System.out.println(list);
		/*
		 * 自然排序，从小到大的顺序，升序排列。
		 */
		Collections.sort(list);//[6, 4, 68, 96, 53, 29, 17, 15, 94, 59]
		System.out.println(list);//[4, 6, 15, 17, 29, 53, 59, 68, 94, 96]
	}
}













