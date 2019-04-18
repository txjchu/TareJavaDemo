package day03;

import homework02.Emp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合存放的是元素的引用
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Emp e = new Emp("张三",25,"男",5000);
		c.add(e);
		
		System.out.println(c);
		
		e.setName("李四");
		
		System.out.println(c);
		
	}
}




