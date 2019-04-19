package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		
		list.add(new Point(7,5));
		list.add(new Point(2,3));
		list.add(new Point(1,2));
		list.add(new Point(4,9));
		list.add(new Point(8,6));
		
		System.out.println(list);
		/*
		 * 若希望使用Collections的sort方法排序，
		 * List中的元素必须实现了Comparable接口。
		 * 该接口表明其子类是可以比较大小的。
		 * Java提供的类大多数都实现了该接口。
		 * 例如：
		 * Integer,Double,String 等等。
		 */
		Collections.sort(list);
		
		System.out.println(list);
		
	}
}
