package day04.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 只能转换为List集合，因为Set集合中不能存放重复元素。
 * 转换依靠数组的工具类Arrays提供的静态方法：
 * asList()
 * @author Administrator
 *
 */
public class ArrayToListDemo01 {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		List<String> list = Arrays.asList(array);//将数组转变为集合
		System.out.println(list);//[one, two, three, four]
		
		list.set(0, "1");
		System.out.println(list);//[1, two, three, four]
		
		//查看原来数组中的内容
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * 修改集合中的现有元素，就等于修改了原数组中对应的元素，但是不能对集合进行增删操作。
		 * 若想添加新元素，需要创建一个新集合。
		 */
//		list.add("five");//会抛出异常
		/*
		 * 复制构造器
		 * 该构造方法在创建集合的同时，会将给定的集合中的所有元素存入到当前集合中，所以就相当于复制了一个集合。
		 */
		List<String> list1 = new ArrayList<String>(list);
		System.out.println(list1);//[1, two, three, four]
		list1.add("five");
		System.out.println(list1);//[1, two, three, four, five]
		
	}
}


















