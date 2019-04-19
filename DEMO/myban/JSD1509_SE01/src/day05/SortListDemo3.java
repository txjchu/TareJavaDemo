package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序集合
 * @author Administrator
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("terry");
		list.add("tom");
		list.add("allen");
		list.add("smith");
		list.add("jarry");
		list.add("Ada");
		list.add("Jack");
		
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		/*
		 * 字符串的比较方式是按照第一个字符的编码从小到大的顺序排列，第一个若一样
		 * 则看第二个，以此类推。A-65 a-97 
		 */
		List<String> list1 = new ArrayList<String>();
		
		list1.add("苍老师");
		list1.add("小泽老师");
		list1.add("范老师");
		/**
		 * 【需求】希望按照字符多的大，字符少的小排序。
		 */
		System.out.println(list1);
		//字符串自身的比较大小规则不满足排序需求
		Collections.sort(list1);		
		System.out.println(list1);
		
		//用自定义的比较规则
		MyComparator com=new MyComparator();
		/*
		 * 重载的sort方法允许我们传入一个比较器，
		 * 然后按照比较器的比较大小方式，将集合中的元素按照从小到大的顺序排列，
		 * 并且该方法不要求集合元素必须实现Comparable接口，因为不会用到。
		 */
		Collections.sort(list1,com);
		
		System.out.println(list1);
	}
}
/**
 * 为字符串定义额外的比较规则；
 * 自定义比较器需要实现Comparator接口
 * @author Administrator
 *
 */
class MyComparator implements Comparator<String>{
	/**
	 * 自定义字符串的比较规则
	 * 返回值与Comparable的comparaTo方法一致。
	 * 返回值>0，o1比o2大
	 * 返回值<0，o1比o2小
	 * 返回值=0，o1与o2相等。
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(String o1,String o2){
	
		return o1.length()-o2.length();
	}
}




