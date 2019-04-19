package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 排序集合
 * 排序集合使用集合的工具类Collection；
 * 其提供了一个静态方法sort。
 * 需要注意的是，排序只能排序List集合，因为Set集合的实现不都是有序的。
 * @author Administrator
 *
 */
public class SortListDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		
		Random random=new Random();		//----随机生成
		
		for(int i=0;i<10;i++){
			list.add(random.nextInt(100));
		}
		//打桩
		System.out.println(list);
		
		/*
		 * 自然排序，按照从小到大的顺序
		 */
		Collections.sort(list);
		
		System.out.println(list);
				
	}
}
