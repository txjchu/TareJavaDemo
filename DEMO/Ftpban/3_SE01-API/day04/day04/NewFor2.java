package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用新循环遍历集合
 * @author Administrator
 *
 */
public class NewFor2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		
		/*
		 * 新循环并非新的语法，新循环是编译器认可的
		 * 而非虚拟机。
		 * 编译器在编译源程序时若发现使用新循环遍历
		 * 集合时，会将代码改变为使用迭代器。
		 * 所以新循环遍历集合就是迭代器遍历集合,
		 * 那就不要在遍历集合的过程中通过集合的方法
		 * 删除元素。
		 */
		for(Object o:c){
//		Iterator it = c.iterator();
//		while(it.hasNext()){
//			Object o = it.next();
			String str = (String)o;
			if("#".equals(str)){
				c.remove(str);
			}
		}
		System.out.println(c);
	}
}


package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用新循环遍历集合
 * 
 * @author Administrator
 *
 */
public class NewFor2 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		
		/*
		 * 新循环并非新的方法，新循环是编译器认可的，而非虚拟机。
		 * 编译器在编译源程序时若发现使用新循环遍历集合时，会将代码改变为使用迭加器。
		 * 所以新循环遍历集合就是迭加器遍历集合，
		 * 那就不要在遍历集合的过程中通过集合的方法删除元素。
		 * 
		 * 如果要删除元素，就自己写方法
		 */
		for(Object o:c){
//		Iterator it=c.iterator();
//		while(it.hasNext()){
//			Object o=it.next();
		
			String str=(String)o;
//			if("#".equals(str)){
//				c.remove(str);
//			}			
		}		
		System.out.println(c);
	}
}


