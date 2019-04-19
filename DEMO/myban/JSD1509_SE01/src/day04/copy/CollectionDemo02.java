package day04.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合的批操作
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		//HashSet是Set集合的实现类。
//		Collection c1 = new HashSet();//不可重复集和
		Collection c1 = new ArrayList();
		c1.add("cpp");
		c1.add("java");
		c1.add("php");
		
		Collection c2 = new ArrayList();
		c2.add("c#");
		c2.add("oc");
		c2.add("java");
		/*
		 * 将c2元素全部添加到c1中:
		 * boolean addAll(Collection c)
		 * 该方法的作用是将给定集合中的所有元素添加到当前集合中，只要当前集合的元素个数发生了改变，就返回true。
		 */
		c1.addAll(c2);
		System.out.println(c1);//[cpp, java, php, c#, oc, java]
		
		Collection c3 = new ArrayList();
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合中是否包含给定集合中的所有元素。全部包含则返回true。判断包含仍然是依靠集合元素的equals方法的比较结果。
		 */
		c3.add("php");
		c3.add("c#");
//		c3.add("c");
		System.out.println(c3);//[php, c#]
		boolean contains = c1.containsAll(c3);
		System.out.println("是否全包含："+ contains);//是否全包含：true
	}
}




















