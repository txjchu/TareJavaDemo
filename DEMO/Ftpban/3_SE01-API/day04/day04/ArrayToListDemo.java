package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 只能转换为List集合，因为Set集合中不能存放重复
 * 元素。
 * 转换依靠数组的工具类Arrays提供的静态方法:
 * asList()
 * @author Administrator
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array 
			= {"one","two","three","four"};
		
		List<String> list
			= Arrays.asList(array);
		
		System.out.println(list);
		
		list.set(0, "1");
		System.out.println(list);
		
		//查看原来数组内容
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * 修改集合中现有元素，就等于修改了
		 * 原数组中对应的元素。但是不能对集合
		 * 进行增删操作。
		 * 若想添加新元素，需要创建一个新集合
		 */
//		list.add("five");
		/*
		 * 复制构造器
		 * 该构造方法在创建集合的同时会将给定的集合
		 * 中所有元素存入当前集合中。所以就相当于
		 * 复制了一个集合。
		 */
		List<String> list1
			= new ArrayList<String>(list);
		
		System.out.println(list1);
		list1.add("five");
		System.out.println(list1);
	}
}





