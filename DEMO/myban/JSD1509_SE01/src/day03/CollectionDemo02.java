package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 判断集合中是否含有给定元素
 * boolean contains(E e)
 * 集合判断给懂元素是否被包含是依据给定元素与集合现有元素是否存在equals比较为true的情况决定，true则认为包含。
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		Emp e1 = new Emp("张三", 25, "男", 5000);
		c.add(e1);
		c.add(new Emp("李四", 24, "女", 4000));
		c.add(new Emp("王五", 23, "男", 4000));
		System.out.println(c);
		
		Emp e2 = new Emp("张三", 26, "男", 7000);
		System.out.println(e1 == e2);//false
		/*
		 * 因为e2与集合中的第一个元素，也就是e1的equals比较为true,所以认为集合包含e2
		 */
		boolean contains = c.contains(e2);
		System.out.println("是否包含："+ contains);
	}
}













