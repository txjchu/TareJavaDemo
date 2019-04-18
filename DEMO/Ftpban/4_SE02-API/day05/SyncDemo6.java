package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 通过Collections可以将现有的集合或Map
 * 转换为线程安全的
 * @author Administrator
 *
 */
public class SyncDemo6 {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		
		/*
		 * 将现有的List集合转换为线程安全的
		 * 返回的List集合是一个线程安全的，并且包含
		 * 原集合中的所有元素
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		//HashSet也不是线程安全的
		Set<String> set 
			= new HashSet<String>(list);
		System.out.println(set);
		//将给定的Set集合转换为一个线程安全的
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		//HashMap也不是线程安全的
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		//转换为线程安全的Map
		map = Collections.synchronizedMap(map);
		System.out.println(map);
			
		
	}
}






