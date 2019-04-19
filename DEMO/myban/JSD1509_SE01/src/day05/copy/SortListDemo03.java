package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序集合
 * @author Administrator
 *
 */
public class SortListDemo03 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("terry");
		list.add("tom");
		list.add("allen");
		list.add("smith");
		list.add("jarry");
		list.add("Ada");
		list.add("Jack");
		System.out.println(list);//[terry, tom, allen, smith, jarry, Ada, Jack]
		Collections.sort(list);
		System.out.println(list);//[Ada, Jack, allen, jarry, smith, terry, tom]
		
		/*
		 * 字符串的比较方式是按照第一个字符的编码从小到大的顺序排列，第一个字符若一样，则比较第二个字符，以此类推。
		 */
		List<String> list1 = new ArrayList<String>();
		list1.add("苍老师");
		list1.add("小泽老师");
		list1.add("范老师");
		list1.add("");
		list1.add("");
		list1.add("");
		list1.add("");
		/*
		 * 希望按照字符多的大，字符少的小排序。
		 */
		System.out.println(list1);//[苍老师, 小泽老师, 范老师, , , , ]
		//字符串自身的比较大小规则不能满足排序的需求。
		Collections.sort(list1);
		System.out.println(list1);//[, , , , 小泽老师, 苍老师, 范老师]
		
		//使用自定义的比较规则
		MyComparator com = new MyComparator();
		/*
		 * 重载的sort方法允许我们传入一个比较器，然后按照比较器的比较大小方式，将集合中的元素按照从小到大的顺序排序，
		 * 并且该方法不要求集合元素必须实现Comparable接口，因为不会用到。	 
		 */
		
		Collections.sort(list1, com);
		System.out.println(list1);//[, , , , 苍老师, 范老师, 小泽老师]
	}
}

/**
 * 为字符串定义额外的比较规则
 * 自定义比较器需要实现Comparator接口。
 */
class MyComparator implements Comparator<String>{
	/*
	 * 自定义字符串的比较规则
	 * 返回值与Comparable的comparaTo方法一致。
	 */
	public int compare(String o1, String o2){
		return o1.length() - o2.length();
	}
}















