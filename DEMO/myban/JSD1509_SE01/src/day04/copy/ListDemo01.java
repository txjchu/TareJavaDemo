package day04.copy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List是可重复集，且有序。
 * 特点：允许通过下标操作元素。
 * 常用实现类：
 * ArrayList：内部由数组实现，利于查询。
 * LinkedList：内部由链表实现，利于增删。
 * 
 * List提供了一些基于下标操作元素的 方法。
 * @author Administrator
 *
 */
public class ListDemo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
//		List<String> list = new LinkedList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);//[one, two, three, four]
		
		/*
		 * E get(int index)获取指定下标位置对应的元素。
		 */
		String str = list.get(1);
		System.out.println(str);//two
		
		for(int i = 0; i < list.size(); i ++){
			str = list.get(i);
			System.out.println(str);
		}
		/*
		 * E set(int index, E e)
		 * 将给定的元素设置到给定的位置上，返回值为原位置上的那个元素。所以是替换元素操作。
		 */
		//[ont, two, three, four]
		String old = list.set(1, "2");
		System.out.println(list);//[one, 2, three, four]
		System.out.println("old:"+ old);//old:two
		
		List<String> list1 = new ArrayList<String>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		list1.set(1, list1.set(2, list1.get(1)));
		System.out.println(list1);
	}
}














