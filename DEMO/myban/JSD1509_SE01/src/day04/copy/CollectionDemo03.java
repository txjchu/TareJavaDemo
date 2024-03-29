package day04.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 * 集合提供了一个方法
 * Iterator iterator()
 * 该方法会获取一个可以遍历当前集合元素的迭代器，然后通过操作该迭代器达到获取集合所有元素的目的。
 * 
 * Iterator 是一个接口，提供了遍历方法。
 * 使用迭代器遍历集合元素需要遵循：
 * 问，取，删的原则。其中删除元素不是必须操作。
 * 不同的集合实现类都提供了用于遍历自身的迭代器实现类，我们无需记住每一个实现类的名字，只将它们当作Iterator操作即可。
 * @author Administrator
 *
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		
		Iterator it = c.iterator();//创建迭代器对象
		/*
		 * boolean hasNext()
		 * 判断集合中是否还有下一个元素
		 */
		while(it.hasNext()){
			/*
			 * E next()
			 * 取出下一个元素。
			 */
			String str = (String) it.next();
			//删除所有#
			/*
			 * 当判断一个字符串变量的值是否与一个字面量的值相同时，应当使用字面量的equals方法与变量比较，这样不会引发空指针异常。
			 */
			if("#".equals(str)){
				/*
				 * 在使用迭代器遍历集合时，不要使用集合的方法修改元素数量。否则可能引发异常。
				 */
//				c.remove(str);
				/*
				 * 迭代器提供了remove()方法，可以删除集合中的元素，而删除的则是next方法取出来的元素。
				 */
				it.remove();
			}
		}
		System.out.println(c);//[one, two, three, four, five]
		
	}
		
}
















