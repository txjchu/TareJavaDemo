package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序含有自定义元素的List集合。
 * @author Administrator
 *
 */
public class SortListDemo02 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(7, 5));
		list.add(new Point(2, 3));
		list.add(new Point(8, 6));
		list.add(new Point(1, 2));
		list.add(new Point(4, 9));
		System.out.println(list);//[7,5, 2,3, 8,6, 1,2, 4,9]
		/*
		 * 若希望使用Collections的sort方法排序，List中的元素必须实现了Comparable接口。
		 * 该接口表面其子类是可以比较大小的。
		 * java提供的类大多数都实现了该接口。例如：Integer,Double,String等。
		 */
		Collections.sort(list);
		System.out.println(list);//[1,2, 2,3, 7,5, 4,9, 8,6]
		
	}
}














