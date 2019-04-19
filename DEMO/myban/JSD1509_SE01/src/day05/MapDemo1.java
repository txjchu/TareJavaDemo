package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * Map  又叫做查找表
 * 以key-value对的形式储存数据。
 * Map要求key不允许重复，是否重复依靠equals比较结果而定。
 * 常用的实现类：
 * HashMap(又名散列表)：使用散列算法实现，查询速度快，在大批量数据检索中时使用它最理想。
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		/*
		 * 所处于java.util包中
		 */
		Map<String,Integer> map=new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * 将给定的key和value存入Map中；
		 * 若给定的key在Map中存在则是替换value，
		 * 并会将被替换的value返回。若不存在则返回值为NULL。
		 * 
		 * 接收返回值时，若value是包装类的话，注意接收时的类型应当也用包装类，
		 * 不要用基本类型。
		 * 因为若给定的key不存在，是不会有value被替换的，返回值则为null，若引发
		 * 自动拆箱会出现空指针异常(NullPointerException)。
		 */
		
//		int old=map.put("语文", 99);
		Integer old=map.put("语文", 99);
		System.out.println("old:"+old);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		System.out.println(map);
		
		old=map.put("语文", 80);//-----是有返回值的
		System.out.println(map);
		System.out.println("old:"+old);
//		System.out.println("old:"+map.put("语文", 80));
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value.
		 * 若给定的key不存在，则返回值为null.
		 */
		
		Integer value=map.get("数学");//----如果写成int，value"体育"一行就会空指针异常
		System.out.println("数学："+value);
		
		value=map.get("体育");
		System.out.println("体育："+value);
		
		/*
		 * V remove(K k)
		 * 将给定的key对应的这条记录删除。返回值为该条记录中的value。
		 */
		System.out.println("删除Map中的英语...");
		old=map.remove("英语");
		System.out.println("old:"+old);
		System.out.println(map);
		
	}
}
