package day05.copy;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 又叫查找表
 * 以key-value 对的形式存储数据。
 * Map要求key不允许重复，是否重复依靠equals比较结果而定。
 * 常用的实现类：
 * HashMap(又名散列表)：使用散列算法实现，查询速度快， 在大批量数据中检索中时使用它最理想。
 * @author Administrator
 *
 */
public class MapDemo01 {
	public static void main(String[] args) {
		//处于java.util包中
		Map<String, Integer> map = new HashMap<String,Integer>();
		/*
		 * V put(K k, V v)
		 * 将给定的key和value存入Map中。
		 * 若给定的key在Map中已经存在，则是替换value，并将被替换的value返回。若不存在则返回值为NULL。
		 * 接收返回值时，若value是包装类的话，注意接收时的类型应当也用包装类，不要用基本类型。
		 * 以为若给定的key不存在，返回值则为Null，用基本类型接收则会因为自动拆装箱引发空指针异常。
		 */
		Integer old = map.put("语文", 99);
		System.out.println("old:"+ old);//old:null
		
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		System.out.println(map);//{物理=96, 语文=99, 英语=97, 数学=98, 化学=95}
		old = map.put("语文", 88);//由于"语文"这个key已经存在，所以是替换value
		System.out.println(map);//{物理=96, 语文=88, 英语=97, 数学=98, 化学=95}
		System.out.println("old:"+ old);//old:99
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value，若给定的key不存在，则会返回null.
		 */
		Integer value = map.get("数学");
		System.out.println("数学："+ value);//数学：98
		
		value = map.get("体育");
		System.out.println("体育："+ value);//体育：null
		
		/*
		 * V remove(K k)
		 * 将给定的Key对应的这条记录删除，返回值为该条记录中的value。
		 */
		System.out.println("删除Map中英语....");
		old = map.remove("英语");
		System.out.println("old:"+ old);
		System.out.println(map);
		
		boolean contains = map.containsKey("化学");
		System.out.println(contains);//true
	}
}
















