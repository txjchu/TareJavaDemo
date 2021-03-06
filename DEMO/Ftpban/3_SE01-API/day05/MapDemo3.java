package day05;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map
 * 遍历Map有三种方式:
 * 1:遍历所有的key
 * 2:遍历每一组key-value对
 * 3:遍历所有value(相对不常用)
 * @author Administrator
 *
 */
public class MapDemo3 {
	public static void main(String[] args) {
		/*
		 * HashMap不关心顺序，put进去的顺序与
		 * 遍历出来时的顺序不一致。
		 * 若希望顺序一致，可以使用LinkedHashMap
		 * 其内部使用了一个LinkedList记录了顺序。
		 */
		Map<String, Integer> map 
			= new LinkedHashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		/*
		 * 遍历所有的key
		 * 
		 * Set<K> keySet()
		 * 该方法会将当前Map中所有的key存入一个Set
		 * 集合中，所以遍历返回的集合即等于遍历了所有
		 * 的key 
		 */
		Set<String> keySet = map.keySet();
		
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * Map中每一组键值对使用一个Entry的实例
		 * 保存，Entry提供了用来获取其表示的键值对
		 * 的方法getKey,getValue
		 * Set<Entry> entrySet()
		 * 该方法会将Map中每一组键值对(若干Entry实例)
		 * 存入一个集合然后返回。
		 * Entry也支持两个泛型，分别表示key与value
		 * 的类型，只要与对应的Map的泛型一致即可。
		 */
		Set<Entry<String,Integer>> entrySet 
							= map.entrySet();
		
		for(Entry<String,Integer> entry:entrySet){
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 遍历所有的value
		 * Collection<V> values()
		 * 该方法会将当前Map中所有的value存入
		 * 一个集合后返回。之所以返回的不是Set
		 * 集合是因为value可以重复。
		 */
		Collection<Integer> values 
						= map.values();
		
		for(Integer value : values){
			System.out.println("values:"+value);
		}

		
	}
}







