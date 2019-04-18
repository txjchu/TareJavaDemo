package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 又叫做查找表
 * 以key-value对的形式存储数据。
 * Map要求key不允许重复，是否重复依靠equals比较结果而定
 * 常用的实现类:
 * HashMap(又名散列表):使用散列算法实现，查询速度快，
 * 在大批量数据中检索中时使用它最理想。
 * 
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		/*
		 * 所处于java.util包中
		 */
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		/*
		 * V put(K k,V v)
		 * 将给定的key和value存入Map中。
		 * 若给定的key在Map中存在则是替换value，
		 * 并会将被替换的value返回。若不存在则返回
		 * 值为NULL。
		 * 接收返回值时，若value是包装类的话，注意
		 * 接收时的类型应当也用包装类，不要用基本类型
		 * 因为若给定的key不存在，是不会有value被替换
		 * 的，返回值则为null,若引发自动拆箱会出现
		 * 空指针异常。
		 */
		Integer old = map.put("语文", 99);
		System.out.println("old:"+old);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		System.out.println(map);
		//由于"语文"这个key存在了，所以是替换value
		old = map.put("语文", 80);
		System.out.println(map);
		System.out.println("old:"+old);
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value.
		 * 若给定的key不存在，则返回值为null
		 */
		Integer value = map.get("数学");
		System.out.println("数学:"+value);
		
		value = map.get("体育");
		System.out.println("体育:"+value);
		
		
		/*
		 * V remove(K k)
		 * 将给定的key对应的这条记录删除。
		 * 返回值为该条记录中的value
		 */
		System.out.println("删除Map中的英语..");
		old = map.remove("英语");
		System.out.println("old:"+old);
		System.out.println(map);
		
	}
}





