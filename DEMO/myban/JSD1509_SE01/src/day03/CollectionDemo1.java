package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 集合，可以保存一组元素，其提供了便于操作元素的相关方法。
 * 派生了两个子类别：
 * List:可重复集；  		Set:不可重复集
 * 判定元素是否有重复，是依靠元素自身equals方法比较的结果。也就是说Set集合中不会
 * 出现2个元素equals比较为true的情况。
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		
		/*
		 * boolean add(E e)
		 * 向集合中添加一个新元素。
		 * 若成功添加则返回true
		 * 
		 * 通常集合中不会存入不同类型元素，因为取出时会变得非常不方便。
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * 集合都重写了toString方法
		 * 格式：
		 * [元素1.toString(),元素2.toString(),……]		 * 
		 */
		System.out.println(c);
		/*
		 * int size()
		 * 查看当前集合中的元素数量
		 */
		int size=c.size();
		System.out.println("size:"+size);
		/*
		 * boolean isEmpty()
		 * 查看当前集合是否不含有任何元素
		 * 当集合中一个元素都没有的时候，返回true。
		 */
		boolean isEmpty=c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		/*
		 * void clear()
		 * 清空当前集合
		 */
		c.clear();
		
		System.out.println("size:"+c.size());
		
		System.out.println("isEmpty:"+c.isEmpty());
		
		
		
	}
}
