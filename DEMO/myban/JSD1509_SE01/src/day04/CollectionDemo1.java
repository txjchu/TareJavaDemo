package day04;

import java.util.ArrayList;
import java.util.Collection;

import day03.Emp;

/**
 * 删除集合元素
 * boolean remove(E e)
 * 从集合中删除给定元素
 * 
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Emp("张三",22,"男",5000));
		c.add(new Emp("李四",23,"女",6000));
		c.add(new Emp("王五",24,"男",7000));
		c.add(new Emp("赵六",25,"女",8000));
		
		System.out.println(c);
	
		Emp e=new Emp("张三",22,"男",5000);
		/*
		 * 该方法会删除集合中第一个与给定元素equals比较为true的元素，所以后续
		 * 若还有equals比较为true的元素是不会删除的。
		 */
		c.remove(e);
		
		System.out.println(c);

	}
}
