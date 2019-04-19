package day04;

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
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		
		for(int i=0;i<array.length;i++){
			String str=array[i];
			System.out.println(str);
		}
		
		
		List<String> list=Arrays.asList(array);
		
		System.out.println(list);
		
		list.set(0, "1");
		System.out.println(list);
		
		//查看原来数组内容
		for(String str: array){
			System.out.println(str);
		}
		
		
		
		/*
		 * 复制构造器
		 * 该构造方法在创建集合的同时会将给定的集合中所有元素
		 * 
		 * List<String>list1=new Array(list);在创建新集合的同时，把list集合
		 * 复制到list1
		 */
		List<String> list1=new ArrayList<String>(list);
		System.out.println(list1);
		list1.add("five");
		System.out.println(list1);
	}
}
