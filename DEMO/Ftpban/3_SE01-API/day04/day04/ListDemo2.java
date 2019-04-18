package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供的方法:
 * void add(int index,E e)
 * 向指定位置插入一个元素，原位置及后续元素顺序
 * 向后移动。
 * 
 * E remove(int index)
 * 删除指定位置上的元素，并将被删除的元素返回。
 * @author Administrator
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list);
		
		//[one,2,two,three,four]
		list.add(1,"2");
		System.out.println(list);
		
		
		//[one,2,three,four]
		String old = list.remove(2);
		System.out.println(list);
		System.out.println("old:"+old);
		
	} 
}







