package day05.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 测试当Emp中的HashCode方法返回值为固定数字且没有重写equals方法时，Map中元素的表现
 * @author Administrator
 *
 */
public class TestEmp_HashCode {
	public static void main(String[] args) {
		/*
		 * 以Emp对象为key时，则会因为Emp没有重写equals方法，而使Map中发生重复key错误。
		 * 以Emp对象为value时，String对象，自带equals方法，因此不会出现错误。
		 */
		Map<String, Emp> map = new HashMap<String, Emp>();
		map.put("张三", new Emp("张三", 22, "男", 4444));
		map.put("李四", new Emp("李四", 23, "女", 4443));
		map.put("王五", new Emp("王五", 24, "男", 3333));
		Emp e = map.get("张三");//没有equals方法比较，返回Null
		System.out.println(e);
		map.remove(new Emp("张三", 22, "男", 4444));//没有equals方法比较，删除失败.
		System.out.println(map.size());
		map.put("张三", new Emp("张三", 23, "女", 2222));
		
		Set<Entry<String, Emp>> entrys = map.entrySet();
		for(Entry<String, Emp> s : entrys){
			System.out.println(s);
		}
	}
}
