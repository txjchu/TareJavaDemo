package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List是可重复集，且有序
 * 特点:允许通过下标操作元素
 * 常用实现类:
 * ArrayList:内部由数组实现，利于查询。
 * LinkedList:内部由链表实现，利于增删。
 * 
 * List提供了一些基于下标操作元素的方法。
 * @author Administrator
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();
//		List<String> list 
//			= new LinkedList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list);
		
		/*
		 * E get(int index)
		 * 获取指定下标位置对应的元素
		 */
		String str = list.get(1);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * 将给定的元素设置到给定的位置上，
		 * 返回值为原位置上的元素。
		 * 所以是替换元素操作。
		 */
		//[one,two,three,four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}







