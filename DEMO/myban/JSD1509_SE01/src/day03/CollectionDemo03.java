package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合中存放的是元素的引用。
 * @author Administrator
 *
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Emp e = new Emp("张三", 26, "男", 5000);
		c.add(e);
		System.out.println(c);//[张三,26,男,5000.0,]
		
		e.setName("李四");
		System.out.println(c);//[李四,26,男,5000.0,]
		
		Collection<Emp> cc = new ArrayList();
		c.add(e);
		System.out.println(c);
		System.out.println(c.size());
		int i = 3;
		c.add(i);
		System.out.println(c);
		int size = c.size();
		System.out.println(size);
	}
}













