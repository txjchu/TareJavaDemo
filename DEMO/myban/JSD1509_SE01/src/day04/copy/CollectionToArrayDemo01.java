package day04.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * 集合Collection提供了一个方法toArray(arr)，可以将当前集合转换为一个数组。
 * 
 * @author Administrator
 *
 */
public class CollectionToArrayDemo01 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);//[one, two, three, four]
		
		/*
		 * 由于返回的是对象数组，所以使用起来不方便。
		 */
//		Object[] array = c.toArray();
		/*
		 * <T>T[] toArray(T[] a)
		 * 若给定的数组可以存下集合中的所有元素，则使用给定的数组，若存不下，则会创建一个同类型数组。
		 */
		String[] array = c.toArray(new String[c.size()]);
		for(String str : array){//使用增强for循环遍历数组
			System.out.println(str);
		}
		System.out.println(Arrays.toString(array));//能够成功调用数组的toString方法，[one, two, three, four]
	}
}













