package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合的批量操作方法，批操作
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		
		//HashSet是一个Set集合的实现类
		//Collection c1=new HashSet();
		Collection c1=new HashSet();
		//Collection c1=new ArrayList();
		c1.add("cpp");		//==c++	==	c plas p
		c1.add("java");
		c1.add("php");
		
		Collection c2=new ArrayList();
		c2.add("c#");
		c2.add("oc");
		c2.add("java");
		
		/*
		 * 将c2的元素全部放到c1中
		 * boolean addAll(Collection c)
		 * 该方法的作用是将给定集合中的所有元素添加到当前集合中，只要当前集合的元素个数
		 * 发生了改变，就会返回true。     //------主要针对HashSet不能重复元素，
		 */
		c1.addAll(c2);
		System.out.println(c1);
		
		Collection c3=new ArrayList();
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合中是否包含给定集合中的所有元素。全部包含则返回true。
		 * 包含仍然是依靠集合元素的equals方法的比较结果。
		 */
		c3.add("php");
		c3.add("c#");
//		c3.add("c");
		
		boolean contains=c1.containsAll(c3);
		System.out.println("c3对于c1是否全包含："+contains);
		
	}
}
