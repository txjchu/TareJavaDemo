package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * 集合Collection提供了一个方法toArray()
 * 可以将当前集合转换为一个数组
 * @author Administrator
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c
			= new ArrayList<String>();
		
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * 由于返回的是对象数组，所以使用起来
		 * 不方便
		 */
//		Object[] array = c.toArray();
		/*
		 * 若给定的数组可以存下集合中所有元素，则
		 * 使用给定的数组，若存不下，会创建一个同
		 * 类型数组。
		 */
		String[] array
			= c.toArray(new String[c.size()]);
		for(String str : array){
			System.out.println(str);
		}
		
		
	}
}







