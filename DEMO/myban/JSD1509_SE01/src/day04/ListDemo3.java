package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start,int end)
 * 获取当前字符串的子集。
 * 
 * @author Administrator
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			list.add(i);
		}
		//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(list);
		
		//取出3-7
		List<Integer> subList=list.subList(3,8);//-----含头不含尾
		System.out.println(subList);
		
		/*
		 * 将子集中每个元素扩大10倍
		 */
		for(int i=0;i<subList.size();i++){
			int n=subList.get(i);
			n=n*10;
			subList.set(i,n);//可以写成一句：subList.set(i,subList.get(i)*10);
//			subList.set(i,subList.get(i)*10);
		}
		System.out.println(subList);
		
		/*
		 * 对子集的操作会影响原集合对应的元素。【★】
		 */
		System.out.println(list);
		
		//将3-7从集合中删除
		list.subList(3,8).clear();//----删除子集后原集合也删除相应元素
		System.out.println(list);
		
	}
}
