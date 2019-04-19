package day05.copy;

import java.util.HashMap;
import java.util.Map;

/**
 * Map提供了可以查看是否包含给定内容的方法
 * containsKey()
 * containsValue() 
 * @author Administrator
 *
 */
public class MapDemo02 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		/*
		 * boolean containsKey(K k)
		 * 判断当前Map中是否包含给定的key
		 * 包含的判定标准是依据key的equals的结果
		 */
		boolean ck = map.containsKey("语文");
		System.out.println("key是否包含："+ ck);//key是否包含：true
		
		boolean cv = map.containsValue(99);
		System.out.println("value是否包含："+ cv);//value是否包含：true
		
	}
}















