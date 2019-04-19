package day05.exercise;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * 案例2		测试Emp
 * @author Administrator
 *
 */
public class TestMap {
	Map<Emp, String> emps = new HashMap<Emp, String>();//创建map对象
	
	@Before
	//@Before注解，在JUnit中该注解表示每个测试方法（@Test修饰的方法）执行时都会执行一次有其修饰方法，用于数据的初始化。
//	@Test
	public void testPut(){
		//想map中添加元素
		emps.put((new Emp("张三", 22, "男", 4000)), "张三");
		emps.put((new Emp("李四", 23, "女", 5000)), "李四");
		System.out.println(emps);
	}
	
	@Test
	public void testGet(){
		Emp zhangsan = new Emp("张三", 22, "男", 4000);
		String name = emps.get(zhangsan);
		System.out.println(name);
	}
	
	@Test
	public void testContainsKey(){
		Emp lisi = new Emp("李四", 23, "女", 5000);
		boolean flag = emps.containsKey(lisi);
		System.out.println("李四是否存在与emps中："+ flag);
	}
}
